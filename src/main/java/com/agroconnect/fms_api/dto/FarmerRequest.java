package com.agroconnect.fms_api.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class FarmerRequest {
    private String name;
    private String email;
    private String phone;
    private String type;
}
