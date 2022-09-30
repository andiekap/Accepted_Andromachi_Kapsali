package com.bet.repository;

import com.bet.model.MatchOdd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchOddRepository extends JpaRepository<MatchOdd, Long> {

}
