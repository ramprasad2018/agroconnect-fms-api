package com.agroconnect.fms_api.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DashboardSnapshotRequest {
    private Integer farmId;
    private LocalDate snapshotDate;
    private String jsonData;
}