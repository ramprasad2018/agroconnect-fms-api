package com.agroconnect.fms_api.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "farm_activity_log", schema = "fms")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FarmActivityLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "farm_id")
    private Integer farmId;

    @Column(name = "activity_date")
    private LocalDate activityDate;

    @Column(name = "activity_type")
    private String activityType;

    private String notes;
    private String status;
}