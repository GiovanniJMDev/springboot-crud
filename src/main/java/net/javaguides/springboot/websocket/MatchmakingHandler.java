package net.javaguides.springboot.websocket;// Ruta sugerida: src/main/java/com/tuempresa/tuapp/websocket/MatchmakingHandler.java
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MatchmakingHandler extends TextWebSocketHandler {

    private final Map<String, WebSocketSession> waitingPlayers = new ConcurrentHashMap<>();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        waitingPlayers.put(session.getId(), session);
        checkForMatch(session);
    }

    private void checkForMatch(WebSocketSession session) throws Exception {
        if (waitingPlayers.size() >= 2) {
            WebSocketSession player1 = waitingPlayers.values().iterator().next();
            WebSocketSession player2 = waitingPlayers.get(session.getId());

            waitingPlayers.remove(player1.getId());
            waitingPlayers.remove(player2.getId());

            sendMatchSuccess(player1, player2);
        } else {
            scheduler.schedule(() -> {
                if (waitingPlayers.containsKey(session.getId())) {
                    waitingPlayers.remove(session.getId());
                    try {
                        session.sendMessage(new TextMessage("No se ha encontrado rival en el tiempo esperado."));
                        session.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, 10, TimeUnit.SECONDS);
        }
    }

    private void sendMatchSuccess(WebSocketSession player1, WebSocketSession player2) throws Exception {
        player1.sendMessage(new TextMessage("Te has emparejado con un rival."));
        player2.sendMessage(new TextMessage("Te has emparejado con un rival."));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        waitingPlayers.remove(session.getId());

        if (waitingPlayers.containsKey(session.getId())) {
            WebSocketSession opponent = waitingPlayers.get(session.getId());
            opponent.sendMessage(new TextMessage("Tu rival se ha desconectado. Por favor, vuelve a buscar."));
            opponent.close();
        }
    }
}
