package com.agroconnect.fms_api.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FarmRequest {
    private Integer farmerId;
    private String name;
    private String location;
    private BigDecimal sizeInAcres;
    private String cropType;
    private String soilQuality;
    private String irrigationType;
}
