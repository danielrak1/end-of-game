package com.example.endofgame.controller;

import com.example.endofgame.dto.CategorySummary;
import com.example.endofgame.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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

    //TODO: avoid category duplicates
    @PostMapping("/categories")
    public ResponseEntity<CategorySummary> createNewCategory(@RequestBody CategorySummary newCategory){
        log.info("Trying to create new category from request object: [{}]", newCategory);

            var createdCategory = service.createNewCategory(newCategory);
            return ResponseEntity.created(URI.create("/categories/" + createdCategory.id())).body(createdCategory);

    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable("id") Long idOfCategoryToDelete){

        if (service.readCategoryById(idOfCategoryToDelete).isPresent()){
            service.deleteCategoryById(idOfCategoryToDelete);
            return new ResponseEntity<>("Category deleted", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Category does not exist", HttpStatus.BAD_REQUEST);
        }
    }



}
