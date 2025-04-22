package com.agroconnect.fms_api.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class LoginResponse {
    private String message;
    private String username;
    private String role;
}
