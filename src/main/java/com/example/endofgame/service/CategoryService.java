package com.example.endofgame.service;

import com.example.endofgame.converter.CategoryConverter;
import com.example.endofgame.dto.CategorySummary;
import com.example.endofgame.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryService {

    private final CategoryRepository repository;

    private final CategoryConverter converter;

    public CategoryService(final CategoryRepository repository, final CategoryConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    public List<CategorySummary> readAllCategories(){
        log.info("reading all categories");

        var result= repository.findAll()
                .stream()
//                .map(category -> converter.fromEntityToDto(category))
                .map(converter::fromEntityToDto)
                .toList();
        log.info("number of read categories: [{}]", result.size());
        log.debug("result: {}", result);

        return result;
    }

    public CategorySummary readCategoryById(Long myId) {
        //TODO: add logger
        log.info("reading category by id");
        var result = repository.findById(myId);
        return result
                .map(converter::fromEntityToDto)
                .orElse(null);
    }
}
