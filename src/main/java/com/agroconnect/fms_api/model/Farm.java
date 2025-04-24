package com.agroconnect.fms_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "farm", schema = "fms")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "farmer_id", nullable = false)
    private Integer farmerId;

    private String name;
    private String location;

    @Column(name = "size_in_acres")
    private BigDecimal sizeInAcres;

    @Column(name = "crop_type")
    private String cropType;

    @Column(name = "soil_quality")
    private String soilQuality;

    @Column(name = "irrigation_type")
    private String irrigationType;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}
