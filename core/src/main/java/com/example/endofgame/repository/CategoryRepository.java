package com.example.endofgame.repository;

import com.example.endofgame.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    boolean existsByName(String name);
    boolean existsByCreationTimestamp(LocalDateTime creationTimestamp);
    boolean existsByUpdateTimestamp(LocalDateTime updateTimestamp);
    boolean existsByNameAndCreationTimestampAndUpdateTimestamp(String name, LocalDateTime creationTimestamp, LocalDateTime updateTimestamp);
}
