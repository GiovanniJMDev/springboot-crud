package net.javaguides.springboot.models;

import jakarta.persistence.*;


@Entity
@Table(name = "Player")
public class Player
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(nullable = false)
    private String name;

    private int uses;

    private int wins;
    private int draws;
    private int losses;

    // Constructor vacío para JPA
    public Player() {}

    // Constructor con todos los parámetros
    public Player(String name, int uses, int wins, int draws, int losses) {
        this.name = name;
        this.uses = uses;
        this.wins = wins;
        this.draws = draws;
        this.losses = losses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getUses() {
        return uses;
    }

    public void setUses(int uses) {
        this.uses = uses;
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