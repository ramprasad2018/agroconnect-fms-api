package com.agroconnect.fms_api.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FarmRevenueRequest {
    private Integer farmId;
    private LocalDate revenueDate;
    private String source;
    private Double amount;
    private LocalDate paymentReceivedDate;
}