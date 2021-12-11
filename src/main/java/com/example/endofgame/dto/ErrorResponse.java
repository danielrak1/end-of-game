package com.example.endofgame.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record ErrorResponse(@JsonFormat(pattern = "'date:'dd-mm-yyyy") LocalDateTime timestamp,
                            String genericMessage,
                            String detailMessage,
                            int responseStatus,
                            String path) {
}
