package com.agroconnect.fms_api.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SoilTestRequest {
    private Integer farmId;
    private LocalDate testDate;
    private Double phLevel;
    private Double nitrogenLevel;
    private Double phosphorusLevel;
    private Double potassiumLevel;
    private String organicMatter;
    private String recommendations;
}