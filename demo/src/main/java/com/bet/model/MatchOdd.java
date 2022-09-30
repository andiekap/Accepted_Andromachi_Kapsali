package com.bet.model;

import javax.persistence.*;

@Entity
@Table(name = "match_odds")
public class MatchOdd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "specifier")
    private String specifier;
    @Column(name = "odd")
    private String odd;

    //otan 8a travaw ena match 8a mou gurnaei kai ta match odds
    @JoinColumn(name = "match_id", nullable = false) //Join at this line
    @ManyToOne(fetch = FetchType.EAGER) //One matchOdd has One Match
    private Match match;

    public Long getId() {
        return id;
    }

    public String getSpecifier() {
        return specifier;
    }

    public void setSpecifier(String specifier) {
        this.specifier = specifier;
    }

    public String getOdd() {
        return odd;
    }

    public void setOdd(String odd) {
        this.odd = odd;
    }
}