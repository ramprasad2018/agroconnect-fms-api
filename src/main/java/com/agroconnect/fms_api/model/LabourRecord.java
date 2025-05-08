package com.agroconnect.fms_api.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "labour_record", schema = "fms")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LabourRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "farm_id")
    private Integer farmId;

    @Column(name = "labourer_name")
    private String labourerName;

    @Column(name = "work_date")
    private LocalDate workDate;

    @Column(name = "hours_worked")
    private Double hoursWorked;

    @Column(name = "task_description")
    private String taskDescription;
}