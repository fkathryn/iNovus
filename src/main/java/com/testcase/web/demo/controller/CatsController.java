package com.testcase.web.demo.controller;


import com.testcase.web.demo.service.CatsService;
import com.testcase.web.demo.service.impl.CatsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vote")
@AllArgsConstructor
public class CatsController {

    private final CatsService catsService;

}
