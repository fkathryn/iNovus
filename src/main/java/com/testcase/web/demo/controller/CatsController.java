package com.testcase.web.demo.controller;

import com.testcase.web.demo.entity.dto.CatsDto;
import com.testcase.web.demo.repository.CatsRepository;
import com.testcase.web.demo.service.CatsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
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

    @GetMapping("/templates/vote")
    public ModelAndView getCats() {
        List<CatsDto> pairCats = catsService.getPairCats();
        if (pairCats.isEmpty()) {
            ModelAndView modelAndView = new ModelAndView("top");
            List<CatsDto> topCats = catsService.getTopCats();
            return (modelAndView.addObject("topCats", topCats));
        }
        ModelAndView modelAndView = new ModelAndView("vote");
        modelAndView.addObject("cats", pairCats);
        return modelAndView;
    }
}
