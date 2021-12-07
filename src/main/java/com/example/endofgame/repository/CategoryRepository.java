package com.example.endofgame.repository;

import com.example.endofgame.dto.CategorySummary;
import com.example.endofgame.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByName(CategorySummary name);
}
