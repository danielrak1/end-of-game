package com.example.endofgame.controller.web;

import com.example.endofgame.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/web")
public class CategoryWebController {

    public static final String CATEGORIES_KEY = "categories";
    private final CategoryService categoryService;

    public CategoryWebController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/all-categories")
    public String allCategories(Model model) {
        model.addAttribute(CATEGORIES_KEY, categoryService.readAllCategories());
        return "/all-categories";
    }

    @GetMapping("delete-category/{id}")
    public String deleteCategoryById(@PathVariable("id") Long id) {
        log.info("deleting category by id: [{}]", id);

        categoryService.deleteCategoryById(id);

        return "redirect:/web/all-categories";
    }

}
