package com.agroconnect.fms_api.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PesticideUsageRequest {
    private Integer farmId;
    private LocalDate applicationDate;
    private String pesticideType;
    private Double quantity;
    private String targetPest;
}