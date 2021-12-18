package com.example.endofgame.controller.web;

import com.example.endofgame.dto.CategorySummary;
import com.example.endofgame.dto.ExpenseSummary;
import com.example.endofgame.entity.Category;
import com.example.endofgame.entity.Expense;
import com.example.endofgame.service.ExpenseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/web")
public class ExpenseWebController {

    public static final String EXPENSE_KEY = "expenses";
    private final ExpenseService expenseService;

    public ExpenseWebController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/expenses")
    public String allCategories(Model model) {
        model.addAttribute(EXPENSE_KEY, expenseService.readAllExpenses());
        return "/expenses";
    }

    @GetMapping("delete-expense/{id}")
    public String deleteExpenseById(@PathVariable("id") Long id) {
        log.info("deleting expense by id: [{}]", id);

        expenseService.deleteExpenseById(id);

        return "redirect:/web/expenses";
    }

    @PostMapping("/add-expense")
    public String createNewExpense(ExpenseSummary expenseSummary){
        expenseService.createNewExpense(expenseSummary);

        return "redirect:/web/expenses";
    }

    @GetMapping("/add-expense")
    public String AddExpenseForm(Model model){
        model.addAttribute("expense", new Expense());
        return "add_expense";
    }
}
