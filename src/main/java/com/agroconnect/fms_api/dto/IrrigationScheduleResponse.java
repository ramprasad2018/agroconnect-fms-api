package com.agroconnect.fms_api.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class IrrigationScheduleResponse {
    private Integer id;
    private Integer farmId;
    private LocalDate scheduledDate;
    private String method;
    private Double waterQuantity;
    private String status;
    private String notes;
    private LocalDateTime createdAt;
}
