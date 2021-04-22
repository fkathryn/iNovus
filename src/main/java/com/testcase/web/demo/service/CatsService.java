package com.testcase.web.demo.service;

import com.testcase.web.demo.entity.Cats;
import com.testcase.web.demo.entity.dto.CatsDto;

import java.util.List;

public interface CatsService {
    CatsDto findByName(String name);
    List<CatsDto> findAll();
    List<CatsDto> getTopCats();
    List<CatsDto> getPairCats();
}
