package com.agroconnect.fms_api.repository;

import com.agroconnect.fms_api.model.SoilTest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SoilTestRepository extends JpaRepository<SoilTest, Integer> {
    List<SoilTest> findByFarmId(Integer farmId);
}