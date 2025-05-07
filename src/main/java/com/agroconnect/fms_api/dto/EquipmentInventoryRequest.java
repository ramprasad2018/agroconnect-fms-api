package com.agroconnect.fms_api.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentInventoryRequest {
    private Integer farmId;
    private String equipmentName;
    private Integer quantity;
    private String condition;
    private LocalDate purchaseDate;
    private LocalDate maintenanceDate;
    private String status;
}