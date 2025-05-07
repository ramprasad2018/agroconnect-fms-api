package com.agroconnect.fms_api.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiseasePestRecordRequest {
    private Integer farmId;
    private LocalDate reportDate;
    private String issueType;
    private String severity;
    private String notes;
    private String actionTaken;
}