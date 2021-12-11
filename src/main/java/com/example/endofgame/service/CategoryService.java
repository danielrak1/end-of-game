package com.example.endofgame.service;

import com.example.endofgame.converter.CategoryConverter;
import com.example.endofgame.dto.CategorySummary;
import com.example.endofgame.entity.Category;
import com.example.endofgame.exception.DeletingNonExistentObject;
import com.example.endofgame.exception.DuplicateCategoryException;
import com.example.endofgame.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CategoryService {

    private final CategoryRepository repository;

    private final CategoryConverter converter;

    public CategoryService(final CategoryRepository repository, final CategoryConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    public List<CategorySummary> readAllCategories() {
        log.info("reading all categories");

        var result = repository.findAll()
                .stream()
//                .map(category -> converter.fromEntityToDto(category))
                .map(converter::fromEntityToDto)
                .toList();
        log.info("number of read categories: [{}]", result.size());
        log.debug("result: {}", result);

        return result;
    }

    public Optional<CategorySummary> readCategoryById(Long myId) {
        var result = repository.findById(myId);
        log.info("item with id: [{}] exists? - [{}]", myId, result.isPresent());
        log.debug("received category: [{}]", result.orElse(null));
        return result.map(converter::fromEntityToDto);
    }

    public boolean isDuplicate(CategorySummary newCategory) {
        List<CategorySummary> myList = readAllCategories();
        for (CategorySummary categorySummary : myList) {
            if (categorySummary.name().equals(newCategory.name())) {
                log.info("Category [{}] exist", newCategory.name());
                return true;
            }
        }
        return false;
    }

    @Transactional
    public CategorySummary createNewCategory(CategorySummary newCategory) throws DuplicateCategoryException {
        if(repository.existsByName(newCategory.name())){
            throw new DuplicateCategoryException(String.format("Category with name: [%s] already exists", newCategory.name()));
        }
        Category toSave = converter.fromDtoToEntity(newCategory);
        Category saved = repository.save(toSave);

        log.info("creating new category");
        log.info("object before conversion [{}]", newCategory);
        log.info("object after conversion [{}]", toSave);
        log.info("saved object [{}]", saved);

        return converter.fromEntityToDto(saved);
    }

    public CategorySummary updateCategory(CategorySummary categorySummary){
        Category toSave = converter.fromDtoToEntity(categorySummary);
        Category saved = repository.save(toSave);


        return converter.fromEntityToDto(saved);
    }

    @Transactional
    public void deleteCategoryById(Long idOfCategoryToDelete) throws DeletingNonExistentObject {
        log.info("Trying to delete category by [{}]", idOfCategoryToDelete);

        if (repository.existsById(idOfCategoryToDelete)) {
            repository.deleteById(idOfCategoryToDelete);

        } else {
            var exception = new DeletingNonExistentObject(String.format("You're trying to delete non existent category with id: [%d]", idOfCategoryToDelete));
            log.warn("problem  with deleting category", exception);
            throw exception;
        }
    }
}
