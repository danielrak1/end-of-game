package com.example.endofgame.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public record ExpenseSummary(Long id,
                             String description,
                             double amount,
                             LocalDate expenseDate,
                             LocalDateTime updated) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpenseSummary that = (ExpenseSummary) o;
        return Double.compare(that.amount, amount) == 0 && Objects.equals(description, that.description) && Objects.equals(expenseDate, that.expenseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, amount, expenseDate);
    }
}
