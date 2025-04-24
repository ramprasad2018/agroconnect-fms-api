package com.agroconnect.fms_api.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CropPlanRequest {
    private Integer farmId;
    private String cropName;
    private LocalDate plantingDate;
    private LocalDate expectedHarvestDate;
    private String seedType;
    private String fertilizerPlan;
    private String notes;
}