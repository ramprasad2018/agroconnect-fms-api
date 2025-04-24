package com.agroconnect.fms_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "crop_plan", schema = "fms")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CropPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer farmId;
    private String cropName;
    private LocalDate plantingDate;
    private LocalDate expectedHarvestDate;
    private String seedType;
    private String fertilizerPlan;
    private String notes;

    @Column(updatable = false)
    private LocalDate createdAt;
}