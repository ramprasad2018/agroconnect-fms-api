package com.agroconnect.fms_api.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FarmExpenseResponse {
    private Integer id;
    private Integer farmId;
    private LocalDate expenseDate;
    private String expenseType;
    private Double amount;
    private String paymentMode;
}