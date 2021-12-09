package com.example.endofgame.dto;

import java.time.LocalDateTime;

public record ExpenseSummary(Long id,
                             String description,
                             double amount,
                             LocalDateTime created,
                             LocalDateTime updated) {
}
