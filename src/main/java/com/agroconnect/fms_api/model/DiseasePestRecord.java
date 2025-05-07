package com.agroconnect.fms_api.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "disease_pest_record", schema = "fms")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiseasePestRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "farm_id")
    private Integer farmId;

    @Column(name = "report_date")
    private LocalDate reportDate;

    @Column(name = "issue_type")
    private String issueType;

    private String severity;
    private String notes;

    @Column(name = "action_taken")
    private String actionTaken;
}