package com.agroconnect.fms_api.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "pesticide_usage", schema = "fms")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PesticideUsage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "farm_id")
    private Integer farmId;

    @Column(name = "application_date")
    private LocalDate applicationDate;

    @Column(name = "pesticide_type")
    private String pesticideType;

    private Double quantity;

    @Column(name = "target_pest")
    private String targetPest;
}