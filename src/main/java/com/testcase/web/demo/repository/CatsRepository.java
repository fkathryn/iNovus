package com.testcase.web.demo.repository;

import com.testcase.web.demo.entity.Cats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CatsRepository extends JpaRepository<Cats, Integer> {
    Cats findByName(String name);
    Optional<Cats> findById(Integer id);
    @Query(value = "SELECT * FROM cats_table ORDER BY RAND()", nativeQuery = true)
    Iterable<Integer> findTopById();
}
