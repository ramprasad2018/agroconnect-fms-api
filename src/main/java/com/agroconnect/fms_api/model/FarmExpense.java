package com.agroconnect.fms_api.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "farm_expense", schema = "fms")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FarmExpense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "farm_id")
    private Integer farmId;

    @Column(name = "expense_date")
    private LocalDate expenseDate;

    @Column(name = "expense_type")
    private String expenseType;

    private Double amount;

    @Column(name = "payment_mode")
    private String paymentMode;
}