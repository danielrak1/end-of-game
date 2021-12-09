package com.example.endofgame.converter;

import com.example.endofgame.dto.ExpenseSummary;
import com.example.endofgame.entity.Expense;
import org.springframework.stereotype.Component;

@Component
public class ExpenseConverter implements MappingOperations<Expense, ExpenseSummary> {
    @Override
    public ExpenseSummary fromEntityToDto(Expense entity) {
        return new ExpenseSummary(
                entity.getId(),
                entity.getDescription(),
                entity.getAmount(),
                entity.getCreationTimestamp(),
                entity.getUpdateTimestamp()
        );
    }

    @Override
    public Expense fromDtoToEntity(ExpenseSummary dto) {
        return Expense.builder()
                .id(dto.id())
                .description(dto.description())
                .amount(dto.amount())
                .creationTimestamp(dto.created())
                .updateTimestamp(dto.updated())
                .build();
    }
}
