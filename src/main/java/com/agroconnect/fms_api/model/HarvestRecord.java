package com.agroconnect.fms_api.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "harvest_record", schema = "fms")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HarvestRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "farm_id")
    private Integer farmId;

    @Column(name = "harvest_date")
    private LocalDate harvestDate;

    private String crop;

    @Column(name = "yield_quantity")
    private Double yieldQuantity;

    @Column(name = "quality_grade")
    private String qualityGrade;

    @Column(name = "selling_price")
    private Double sellingPrice;
}