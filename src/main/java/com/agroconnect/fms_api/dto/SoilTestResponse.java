package com.agroconnect.fms_api.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class SoilTestResponse {
    private Integer id;
    private Integer farmId;
    private LocalDate testDate;
    private Double phLevel;
    private Double nitrogenLevel;
    private Double phosphorusLevel;
    private Double potassiumLevel;
    private String organicMatter;
    private String recommendations;
    private LocalDateTime createdAt;
}