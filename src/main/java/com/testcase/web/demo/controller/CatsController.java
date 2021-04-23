package com.testcase.web.demo.controller;

import com.testcase.web.demo.repository.CatsRepository;
import com.testcase.web.demo.service.CatsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CatsController {

    private final CatsService catsService;
    private final CatsRepository catsRepository;

    @PostMapping("/vote")
    public void vote(@RequestBody String catsId) {
        long id = Long.parseLong(catsId);
        if (id > 0 && id <= catsRepository.getMaxId()) {
            catsService.saveVote(id);
        }
    }
}
