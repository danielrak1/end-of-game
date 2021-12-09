package com.example.endofgame.service;

import com.example.endofgame.converter.ExpenseConverter;
import com.example.endofgame.dto.CategorySummary;
import com.example.endofgame.dto.ExpenseSummary;
import com.example.endofgame.repository.ExpenseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ExpenseService {

    private final ExpenseRepository repository;
    private final ExpenseConverter converter;

    public ExpenseService(final ExpenseRepository repository, final ExpenseConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    public List<ExpenseSummary> readAllExpenses() {
        log.info("reading all categories");

        var result = repository.findAll()
                .stream()
                .map(converter::fromEntityToDto)
                .toList();
        log.info("number of read expenses: [{}]", result.size());
        log.debug("result: {}", result);

        return result;
    }

}
