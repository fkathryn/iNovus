package com.testcase.web.demo.service.impl;

import com.testcase.web.demo.entity.Cats;
import com.testcase.web.demo.entity.CatsConverter;
import com.testcase.web.demo.entity.dto.CatsDto;
import com.testcase.web.demo.repository.CatsRepository;
import com.testcase.web.demo.service.CatsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class CatsServiceImpl implements CatsService {

    private final CatsRepository catsRepository;
    private final CatsConverter catsConverter;

    @Override
    public CatsDto findByName(String name) {
        Cats cats = catsRepository.findByName(name);
        if (cats != null) {
            return catsConverter.fromCatsToCatsDto(cats);
        }
        return null;
    }

    @Override
    public List<CatsDto> findAll() {
        return catsRepository.findAll().stream()
                .map(catsConverter::fromCatsToCatsDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CatsDto> getTopCats() {
        List<CatsDto> catslist = new ArrayList<>(10);
        Iterable<Integer> topIds = catsRepository.findTopById();
        for (Integer id : topIds) {
            if (id != null) {
                catslist.add(catsConverter.fromCatsToCatsDto(catsRepository.findById(id).orElse(new Cats())));
            }
        }
        return catslist;
    }

    @Override
    public List<CatsDto> getPairCats() {
        List<CatsDto> catsList = new ArrayList<>(2);

        return catsList;
    }
}
