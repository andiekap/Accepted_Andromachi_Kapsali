package com.bet.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "match")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name = "match_date")
    private LocalDateTime matchDate;
    @Column(name = "team_a")
    private String teamA;
    @Column(name = "team_b")
    private String teamB;
    @Column(name = "sport")
    private Sport sport;

    @OneToMany(
            mappedBy = "match",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<MatchOdd> matchOddList = new ArrayList<>();


    public enum Sport {

        Football("1"),
        Basketball("2");

        private final String name;

        Sport(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(LocalDateTime matchDate) {
        this.matchDate = matchDate;
    }

    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }
}
