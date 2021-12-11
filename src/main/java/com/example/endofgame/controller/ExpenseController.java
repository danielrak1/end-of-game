package com.example.endofgame.controller;

import com.example.endofgame.dto.CategorySummary;
import com.example.endofgame.dto.ExpenseSummary;
import com.example.endofgame.service.ExpenseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api")
public class ExpenseController {

    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @GetMapping("/expenses")
    public List<ExpenseSummary> allExpenses() {
        log.info("endpoint: /expenses");

        return service.readAllExpenses();
    }

    @PostMapping("/expenses")
    public ResponseEntity<ExpenseSummary> createNewExpense(@RequestBody ExpenseSummary newExpense) {
        log.info("Trying to create new expense from request object: [{}]", newExpense);

        if (service.isDuplicate(newExpense)) {
            log.info("Expense already exists");

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else{
            log.info("Expense is new");
            var createdExpense = service.createNewExpense(newExpense);

            return ResponseEntity.created(URI.create("/expenses/" + createdExpense.id())).body(createdExpense);
        }
    }

    @DeleteMapping("/expenses/{id}")
    public ResponseEntity<String> deleteExpenseById(@PathVariable("id") Long idOfExpenseToDelete) {

        if (service.readExpenseById(idOfExpenseToDelete).isPresent()) {
            service.deleteExpenseById(idOfExpenseToDelete);
            return new ResponseEntity<>("Expense deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Expense   does not exist", HttpStatus.BAD_REQUEST);
        }
    }


}
