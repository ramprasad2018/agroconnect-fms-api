package com.agroconnect.fms_api.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "sales_record", schema = "fms")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalesRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "farm_id")
    private Integer farmId;

    @Column(name = "sale_date")
    private LocalDate saleDate;

    private String crop;

    private Double quantity;

    @Column(name = "price_per_unit")
    private Double pricePerUnit;

    @Column(name = "buyer_name")
    private String buyerName;

    @Column(name = "sale_channel")
    private String saleChannel;
}