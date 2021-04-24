package com.testcase.web.demo.repository;

import com.testcase.web.demo.entity.Cats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface CatsRepository extends JpaRepository<Cats, Long> {

    @Override
    List<Cats> findAll();

    Optional<Cats> findById(Long id);

    @Query(value = "SELECT * FROM cats.cats_table ORDER BY RANDOM()", nativeQuery = true)
    Iterable<Cats> findCatsByRand();

    @Query(value = "SELECT id FROM cats.cats_table ORDER BY votes DESC LIMIT 10", nativeQuery = true)
    Iterable<Long> findTopByCountVotes();

    @Query(value = "SELECT MAX(id) FROM cats.cats_table", nativeQuery = true)
    Long getMaxId();

    @Modifying
    @Transactional
    @Query(value = "UPDATE cats.cats_table SET votes = votes + 1 WHERE id = ?1", nativeQuery = true)
    void updateVote(Long id);
}
