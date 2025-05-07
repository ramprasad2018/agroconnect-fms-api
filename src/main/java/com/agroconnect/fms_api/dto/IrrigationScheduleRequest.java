package com.agroconnect.fms_api.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class IrrigationScheduleRequest {
    private Integer farmId;
    private LocalDate scheduledDate;
    private String method;
    private Double waterQuantity;
    private String status;
    private String notes;
}
