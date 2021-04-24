package com.testcase.web.demo.service;

import com.testcase.web.demo.entity.dto.CatsDto;
import java.util.List;

public interface CatsService {
    List<CatsDto> findAll();
    List<CatsDto> getTopCats();
    List<CatsDto> getPairCats();
    void saveVote(Long id);
}
