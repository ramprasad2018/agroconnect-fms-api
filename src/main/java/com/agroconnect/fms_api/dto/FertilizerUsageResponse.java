package com.agroconnect.fms_api.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FertilizerUsageResponse {
    private Integer id;
    private Integer farmId;
    private LocalDate applicationDate;
    private String fertilizerType;
    private Double quantity;
    private String applicationMethod;
}