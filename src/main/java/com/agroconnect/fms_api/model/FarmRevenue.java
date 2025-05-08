package com.agroconnect.fms_api.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "farm_revenue", schema = "fms")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FarmRevenue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "farm_id")
    private Integer farmId;

    @Column(name = "revenue_date")
    private LocalDate revenueDate;

    private String source;
    private Double amount;

    @Column(name = "payment_received_date")
    private LocalDate paymentReceivedDate;
}