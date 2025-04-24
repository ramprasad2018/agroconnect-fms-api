package com.agroconnect.fms_api.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class FarmResponse {
    private Integer id;
    private Integer farmerId;
    private String name;
    private String location;
    private BigDecimal sizeInAcres;
    private String cropType;
    private String soilQuality;
    private String irrigationType;
    private LocalDateTime createdAt;
}
