package com.testcase.web.demo.entity;

import com.testcase.web.demo.entity.dto.CatsDto;
import org.springframework.stereotype.Component;

@Component
public class CatsConverter {

    public Cats fromCatsDtoToCats(CatsDto catsDto) {
        Cats cats = new Cats();
        cats.setId(catsDto.getId());
        cats.setName(catsDto.getName());
        cats.setVotes(cats.getVotes());
        cats.setParticipate(cats.isParticipate());
        return cats;
    }

    public CatsDto fromCatsToCatsDto(Cats cats) {
        return CatsDto.builder()
                .id(cats.getId())
                .name(cats.getName())
                .votes(cats.getVotes())
                .participate(cats.isParticipate())
                .build();
    }
}
