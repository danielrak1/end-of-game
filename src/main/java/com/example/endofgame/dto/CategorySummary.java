package com.example.endofgame.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record CategorySummary(Long id,
                              String name,
                              @JsonFormat(pattern = "'date:'dd-mm-yyyy") LocalDateTime created,
                              @JsonFormat(pattern = "'date:'dd-mm-yyyy") LocalDateTime updated) {
}
