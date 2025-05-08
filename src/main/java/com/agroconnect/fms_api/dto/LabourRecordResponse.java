package com.agroconnect.fms_api.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LabourRecordResponse {
    private Integer id;
    private Integer farmId;
    private String labourerName;
    private LocalDate workDate;
    private Double hoursWorked;
    private String taskDescription;
}