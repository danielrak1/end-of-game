package com.example.endofgame.controller;

import com.example.endofgame.dto.CategorySummary;
import com.example.endofgame.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(final CategoryService service) {
        this.service = service;
    }

    @GetMapping("/categories")
    public List<CategorySummary> allCategories(){
        log.info("endpoint: /categories");

        return service.readAllCategories();
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<CategorySummary> findCategoryById(@PathVariable("id") Long myId){
        log.info("trying to find category with id: [{}]", myId);

        var readCategorySummary = service.readCategoryById(myId);
        var result = ResponseEntity.notFound().<CategorySummary>build();
        if (readCategorySummary.isPresent()){
            result = ResponseEntity.ok(readCategorySummary.get());
        }
        return result;
    }


}
