package com.testcase.web.demo.service;

import com.testcase.web.demo.entity.Cats;

import java.util.List;

public interface CatService {
    List<Cats> findAll();
    Cats findByVotes();
}
