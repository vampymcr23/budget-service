package com.gina.budget.rest.resources;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HealthResponse {
    private LocalDateTime time;
    private String environment;
}
