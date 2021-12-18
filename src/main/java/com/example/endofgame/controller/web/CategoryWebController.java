package com.example.endofgame.controller.web;

import com.example.endofgame.dto.CategorySummary;
import com.example.endofgame.entity.Category;
import com.example.endofgame.entity.User;
import com.example.endofgame.repository.CategoryRepository;
import com.example.endofgame.service.CategoryService;
import com.example.endofgame.service.CustomUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping("/web")
public class CategoryWebController {

    public static final String CATEGORIES_KEY = "categories";
    private final CategoryService categoryService;
    private final CustomUserDetailsService detailsService;
    private final CategoryRepository repository;

    public CategoryWebController(CategoryService categoryService, CustomUserDetailsService detailsService, CategoryRepository repository) {
        this.categoryService = categoryService;
        this.detailsService = detailsService;
        this.repository = repository;
    }

    @GetMapping("/all-categories")
    public String allCategories(Model model) {
        model.addAttribute(CATEGORIES_KEY, categoryService.readAllCategories());
        return "/all-categories";
    }

    @PostMapping("/add-category")
    public String createNewCategory(CategorySummary categorySummary){
        categoryService.createNewCategory(categorySummary);

    return "redirect:/web/all-categories";
    }

    @GetMapping("delete-category/{id}")
    public String deleteCategoryById(@PathVariable("id") Long id) {
        log.info("deleting category by id: [{}]", id);

        categoryService.deleteCategoryById(id);

        return "redirect:/web/all-categories";
    }

    @GetMapping("/add-category")
    public String AddCategoryForm(Model model){
        model.addAttribute("category", new Category());
        return "add_category";
    }

//    @PostMapping("/process_add-category")
//    public String addCategory(Category category){
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User user = detailsService.loadUser(auth.getName());
//        category.setUser(user);
//        repository.save(category);
//
//        return "redirect:/web/all-categories";
//    }

}
