package com.example.endofgame.dto;

import com.example.endofgame.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public record CategorySummary(Long id,

                              @NotEmpty
                              @Size(min = 3)
                              String name,

                              @JsonFormat(pattern = "'date:' dd-MM-yyyy 'time:' HH:mm:ss")
                              LocalDateTime created,

                              @JsonFormat(pattern = "'date:' dd-MM-yyyy 'time:' HH:mm:ss")
                              LocalDateTime updated) {
}
