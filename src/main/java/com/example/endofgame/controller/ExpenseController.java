package com.example.endofgame.controller;

import com.example.endofgame.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ExpenseController {

    @Autowired
    private CategoryRepository repository;

    @GetMapping("/expenses")
    public String viewExpensePage(){
        return "expenses";
    }
}
