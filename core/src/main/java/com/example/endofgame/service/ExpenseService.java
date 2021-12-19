package com.example.endofgame.service;

import com.example.endofgame.converter.ExpenseConverter;
import com.example.endofgame.dto.ExpenseSummary;
import com.example.endofgame.entity.Expense;
import com.example.endofgame.repository.ExpenseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

    public Optional<ExpenseSummary> readExpenseById(Long myId) {
        var result = repository.findById(myId);
        log.info("Expense with id: [{}] exists? - [{}]", myId, result.isPresent());
        log.debug("received expense: [{}]", result.orElse(null));
        return result.map(converter::fromEntityToDto);
    }

    public ExpenseSummary createNewExpense(ExpenseSummary newExpense) {
        Expense toSave = converter.fromDtoToEntity(newExpense);
        Expense saved = repository.save(toSave);

        log.info("creating new expense");
        log.info("object before conversion [{}]", newExpense);
        log.info("object after conversion [{}]", toSave);
        log.info("saved object [{}]", saved);

        return converter.fromEntityToDto(saved);
    }

    public boolean isDuplicate(ExpenseSummary newExpense) {
        List<ExpenseSummary> myList = readAllExpenses();
        for (ExpenseSummary expenseSummary : myList) {
            if (expenseSummary.equals(newExpense)) {
                log.info("Expense [{}] exist", newExpense.description());
                return true;
            }
        }return false;
    }

    @Transactional
    public void deleteExpenseById(Long idOfExpenseToDelete) {
        log.info("Trying to delete expense by id: [{}]", idOfExpenseToDelete);
        if (repository.existsById(idOfExpenseToDelete)) {
            log.info("deleting category with id: [{}]", idOfExpenseToDelete);
            repository.deleteById(idOfExpenseToDelete);

        } else {
            log.info("Expense with id: [{}] does not exist", idOfExpenseToDelete);
        }
    }


}
