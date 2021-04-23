package com.testcase.web.demo.repository;

import com.testcase.web.demo.entity.Cats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CatsRepository extends JpaRepository<Cats, Integer> {

    @Override
    List<Cats> findAll();

    Optional<Cats> findById(Long id);

    @Query(value = "SELECT * FROM cats.cats_table ORDER BY RANDOM()", nativeQuery = true)
    Iterable<Cats> findCatsByRand();

    @Query(value = "SELECT id FROM cats.cats_table ORDER BY votes DESC LIMIT 10", nativeQuery = true)
    Iterable<Long> findTopByCountVotes();
}
