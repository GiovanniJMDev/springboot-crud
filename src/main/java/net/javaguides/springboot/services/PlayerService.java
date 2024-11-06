package net.javaguides.springboot.services;

import net.javaguides.springboot.models.Player;
import net.javaguides.springboot.repository.PlayerRepository;
import net.javaguides.springboot.exceptions.PlayerExceptions.PlayerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Optional<Player> getPlayerById(Long id) {
        return playerRepository.findById(id);
    }

    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player updatePlayer(Long id, Player playerDetails) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException(id));

        player.setName(playerDetails.getName());
        player.setUses(playerDetails.getUses());
        player.setWins(playerDetails.getWins());
        player.setDraws(playerDetails.getDraws());
        player.setLosses(playerDetails.getLosses());

        return playerRepository.save(player);
    }

    public void deletePlayer(Long id) {
        if (!playerRepository.existsById(id)) {
            throw new PlayerNotFoundException(id);
        }
        playerRepository.deleteById(id);
    }
}
