package com.agroconnect.fms_api.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalesRecordResponse {
    private Integer id;
    private Integer farmId;
    private LocalDate saleDate;
    private String crop;
    private Double quantity;
    private Double pricePerUnit;
    private String buyerName;
    private String saleChannel;
}