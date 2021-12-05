package com.example.endofgame.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PersonSummary(@JsonProperty("eesnimiPerekonnanimi") String nameWithSurname) {
}
