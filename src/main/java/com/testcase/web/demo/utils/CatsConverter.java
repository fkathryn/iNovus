package com.testcase.web.demo.utils;

import com.testcase.web.demo.entity.Cats;
import com.testcase.web.demo.entity.dto.CatsDto;
import org.springframework.stereotype.Component;

@Component
public class CatsConverter {

    public Cats fromCatsDtoToCats(CatsDto catsDto) {
        Cats cats = new Cats();
        cats.setId(catsDto.getId());
        cats.setName(catsDto.getName());
        cats.setVotes(catsDto.getVotes());
        cats.setImage(catsDto.getImage());
        return cats;
    }

    public CatsDto fromCatsToCatsDto(Cats cats) {
        return CatsDto.builder()
                .id(cats.getId())
                .name(cats.getName())
                .votes(cats.getVotes())
                .image(cats.getImage())
                .build();
    }
}
