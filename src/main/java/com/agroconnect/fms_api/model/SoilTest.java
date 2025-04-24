package com.agroconnect.fms_api.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "soil_test", schema = "fms")
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class SoilTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "farm_id", nullable = false)
    private Integer farmId;

    @Column(name = "test_date", nullable = false)
    private LocalDate testDate;

    private Double phLevel;
    private Double nitrogenLevel;
    private Double phosphorusLevel;
    private Double potassiumLevel;
    private String organicMatter;
    private String recommendations;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}