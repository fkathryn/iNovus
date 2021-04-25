package com.testcase.web.demo.service.impl;

import com.testcase.web.demo.entity.Cats;
import com.testcase.web.demo.utils.CatsConverter;
import com.testcase.web.demo.entity.dto.CatsDto;
import com.testcase.web.demo.repository.CatsRepository;
import com.testcase.web.demo.service.CatsService;
import com.testcase.web.demo.utils.CatsInQueue;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class CatsServiceImpl implements CatsService {

    private final CatsRepository catsRepository;
    private final CatsConverter catsConverter;
    private CatsInQueue catsInQueue;

    @Override
    public List<CatsDto> findAll() {
        return catsRepository.findAll()
                .stream()
                .map(catsConverter::fromCatsToCatsDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CatsDto> getTopCats() {
        List<CatsDto> catsList = new ArrayList<>(10);
        Iterable<Long> topIds = catsRepository.findTopByCountVotes();
        for (Object id : topIds) {
            if (id instanceof BigInteger) {
                catsList.add(catsConverter.fromCatsToCatsDto(catsRepository.findById(((BigInteger) id).longValue()).orElse(new Cats())));
            }
        }
        return catsList;
    }

    @Override
    public List<CatsDto> getPairCats() {
        Queue<Cats> queueCats = catsInQueue.getQueue();
        Cats firstCat = queueCats.poll();
        Cats secondCat = queueCats.poll();
        if (firstCat == null || secondCat == null) {
            catsInQueue = new CatsInQueue(catsRepository);
            return Collections.emptyList();
        }
        List<CatsDto> catsList = new ArrayList<>(2);
        catsList.add(catsConverter.fromCatsToCatsDto(firstCat));
        catsList.add(catsConverter.fromCatsToCatsDto(secondCat));
        return catsList;
    }

    @Override
    public void saveVote(Long id) {
        List<Cats> cat = catsRepository.findById(id).stream().collect(Collectors.toList());
        catsRepository.updateVote(cat.get(0).getId());
    }
}
