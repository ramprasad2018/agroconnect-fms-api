package com.agroconnect.fms_api.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PesticideUsageResponse {
    private Integer id;
    private Integer farmId;
    private LocalDate applicationDate;
    private String pesticideType;
    private Double quantity;
    private String targetPest;
}