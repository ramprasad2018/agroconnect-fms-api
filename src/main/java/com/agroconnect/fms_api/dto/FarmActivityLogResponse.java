package com.agroconnect.fms_api.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FarmActivityLogResponse {
    private Integer id;
    private Integer farmId;
    private LocalDate activityDate;
    private String activityType;
    private String notes;
    private String status;
}