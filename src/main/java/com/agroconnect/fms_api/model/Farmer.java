package com.agroconnect.fms_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "farmer", schema = "fms")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Farmer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String email;

    private String phone;

    @Column(nullable = false)
    private String type;

    private LocalDateTime createdAt;
}
