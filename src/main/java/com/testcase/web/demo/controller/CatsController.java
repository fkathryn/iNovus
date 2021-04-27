package com.testcase.web.demo.controller;

import com.testcase.web.demo.entity.Cats;
import com.testcase.web.demo.entity.dto.CatsDto;
import com.testcase.web.demo.repository.CatsRepository;
import com.testcase.web.demo.service.CatsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@AllArgsConstructor
public class CatsController {

    private final CatsService catsService;
    private final CatsRepository catsRepository;

    @GetMapping("/")
    public String startPage(Model model) {
        return "start";
    }

    @PostMapping("/vote")
    public void vote(@RequestBody String catsId) {
        long id = Long.parseLong(catsId);
        if (id > 0 && id <= catsRepository.getMaxId()) {
            catsService.saveVote(id);
        }
    }

    @GetMapping("/vote")
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

    @GetMapping("/add_cats")
    public String catsAdd(Model model) {
        return "add_cats";
    }

    @PostMapping("/add")
    public String catsPostAdd(@RequestParam String name,@RequestParam String image, Model model) {
        if (!name.isEmpty() && !image.isEmpty()) {
            Cats cat;
            if (catsRepository.getMaxId() == null) {
                cat = new Cats(0L, image, name, 0);
            } else {
                cat = new Cats(catsRepository.getMaxId() + 1, image, name, 0);
            }
            catsService.addCat(cat);
        }
        return "redirect:/";
    }
}
