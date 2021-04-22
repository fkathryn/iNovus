package com.testcase.web.demo.repository;

import com.testcase.web.demo.entity.Cats;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CatsRepository extends JpaRepository<Cats, Integer> {
    Cats findByName(String name);
    Optional<Cats> findById(Integer id);
    Iterable<Integer> findTopById();
}
