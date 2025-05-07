package com.agroconnect.fms_api.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentInventoryResponse {
    private Integer id;
    private Integer farmId;
    private String equipmentName;
    private Integer quantity;
    private String condition;
    private LocalDate purchaseDate;
    private LocalDate maintenanceDate;
    private String status;
}