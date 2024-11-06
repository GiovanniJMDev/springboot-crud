package net.javaguides.springboot.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Fight")
public class Fight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user1_id", nullable = false)
    private User user1;

    @ManyToOne
    @JoinColumn(name = "user2_id", nullable = false)
    private User user2;

    @ManyToOne
    @JoinColumn(name = "player1_id", nullable = false)
    private Player player1;

    @ManyToOne
    @JoinColumn(name = "player2_id", nullable = false)
    private Player player2;

    @ManyToOne
    @JoinColumn(name = "winner_id", nullable = false)
    private User winner; // ID del usuario ganador

    @Column(name = "day", nullable = false)
    private LocalDate day;

    @Column(name = "time", nullable = false)
    private LocalTime time;

    // Constructors
    public Fight() {
    }

    public Fight(User user1, User user2, Player player1, Player player2, User winner, LocalDate day, LocalTime time) {
        this.user1 = user1;
        this.user2 = user2;
        this.player1 = player1;
        this.player2 = player2;
        this.winner = winner;
        this.day = day;
        this.time = time;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public User getWinner() {
        return winner;
    }

    public void setWinner(User winner) {
        this.winner = winner;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    // toString method for debugging
    @Override
    public String toString() {
        return "Fight{" +
                "id=" + id +
                ", user1=" + user1 +
                ", user2=" + user2 +
                ", player1=" + player1 +
                ", player2=" + player2 +
                ", winner=" + winner +
                ", day=" + day +
                ", time=" + time +
                '}';
    }
}
