package com.testcase.web.demo.repository;

import com.testcase.web.demo.entity.Cats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatsRepository extends JpaRepository<Cats, Integer> {
    Cats findByName(String name);
}
