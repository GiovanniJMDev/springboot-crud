package net.javaguides.springboot.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "user") // Nombre en minúsculas para que coincida con el nombre en la base de datos
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @JsonProperty("nombre")
    private String name;

    @Column(nullable = false)
    private String password;

    @JsonProperty("victorias")
    private int wins;

    @JsonProperty("empates")
    private int draws;

    @JsonProperty("derrotas")
    private int losses;

    public User() {}

    public User(String name, String password, int wins, int draws, int losses) {
        this.name = name;
        this.password = password;
        this.wins = wins;
        this.draws = draws;
        this.losses = losses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }
}
