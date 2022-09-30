package com.bet.controller;

import com.bet.model.Match;
import com.bet.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import src.main.java.com.bet.exception.ResourceNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/bet")
public class ApiController {

    @Autowired
    private MatchRepository matchDBControl;

    @GetMapping("/retrieveAll")
    public List<Match> getAllMatches() {
        return matchDBControl.findAll();
    }

    @GetMapping("/retrieve/{id}")
    public ResponseEntity<Match> getMatchById(@PathVariable(value = "id") Long matchId) throws ResourceNotFoundException {
        Match match = matchDBControl.findById(matchId).orElseThrow(() -> new ResourceNotFoundException("Match not found for this id :: " + matchId));
        return ResponseEntity.ok().body(match);
    }

    @PostMapping("/create")
    public Match createMatch(@RequestBody Match match) {
        return matchDBControl.save(match);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Match> updateMatch(@PathVariable(value = "id") Long matchId, @RequestBody Match matchDetails) throws ResourceNotFoundException {

        Match match = matchDBControl.findById(matchId).orElseThrow(() -> new ResourceNotFoundException("Match not found for this id :: " + matchId));

        match.setDescription(matchDetails.getDescription());
        match.setMatchDate(matchDetails.getMatchDate());
        match.setId(matchDetails.getId());
        match.setTeamA(matchDetails.getTeamA());
        match.setTeamB(matchDetails.getTeamB());

        Match updatedMatch = matchDBControl.save(match);
        return ResponseEntity.ok(updatedMatch);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteMatch(@PathVariable(value = "id") Long matchId) throws ResourceNotFoundException {

        Match match = matchDBControl.findById(matchId).orElseThrow(() -> new ResourceNotFoundException("Match not found for this id :: " + matchId));

        matchDBControl.delete(match);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
