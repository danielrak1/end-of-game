package com.example.endofgame.dto;

import java.time.LocalDateTime;

public record CategorySummary(Long id,
                              String name,
                              // TODO: change format of those two fields for nicer ones
                              LocalDateTime created,
                              LocalDateTime updated) {
}
