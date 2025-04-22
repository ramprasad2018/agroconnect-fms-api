package com.agroconnect.fms_api.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class FarmerResponse {
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String type;
}
