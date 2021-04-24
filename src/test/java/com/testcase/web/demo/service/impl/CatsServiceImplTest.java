package com.testcase.web.demo.service.impl;

import com.testcase.web.demo.entity.dto.CatsDto;
import com.testcase.web.demo.repository.CatsRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class CatsServiceImplTest {

    @Autowired
    private CatsServiceImpl catsService;

    @Test
    void findAll() {
        System.out.println(catsService.findAll().size());
    }

    @Test
    void getTopCats() {
        List<CatsDto> catsList = catsService.getTopCats();
        assertEquals(catsList.size(), 4);
    }

    @Test
    void getPairCats() {
        List<CatsDto> cats = catsService.getPairCats();
        for (CatsDto cat : cats) {
            System.out.println(cat.getName());
        }
    }

    @Test
    void saveVote() {
        long id = 3;
        catsService.saveVote(id);
        System.out.println(catsService.findAll());
    }
}