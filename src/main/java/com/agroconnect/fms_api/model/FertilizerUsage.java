package com.agroconnect.fms_api.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "fertilizer_usage", schema = "fms")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FertilizerUsage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "farm_id")
    private Integer farmId;

    @Column(name = "application_date")
    private LocalDate applicationDate;

    @Column(name = "fertilizer_type")
    private String fertilizerType;

    private Double quantity;

    @Column(name = "application_method")
    private String applicationMethod;
}