package com.agroconnect.fms_api.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WaterUsageLogResponse {
    private Integer id;
    private Integer farmId;
    private LocalDate usageDate;
    private Double litersUsed;
}