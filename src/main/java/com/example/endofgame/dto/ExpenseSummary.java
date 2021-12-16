package com.example.endofgame.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public record ExpenseSummary(Long id,

                             @NotEmpty
                             @Size(min = 3)
                             String description,
                             double amount,

                             @JsonFormat(pattern = "'date:' dd-MM-yyyy 'time:' HH:mm:ss")
                             LocalDate expenseDate,

                             @JsonFormat(pattern = "'date:' dd-MM-yyyy 'time:' HH:mm:ss")
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
