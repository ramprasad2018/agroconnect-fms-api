package com.agroconnect.fms_api.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HarvestRecordRequest {
    private Integer farmId;
    private LocalDate harvestDate;
    private String crop;
    private Double yieldQuantity;
    private String qualityGrade;
    private Double sellingPrice;
}