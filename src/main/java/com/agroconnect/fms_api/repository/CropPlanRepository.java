package com.agroconnect.fms_api.repository;

import com.agroconnect.fms_api.model.CropPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CropPlanRepository extends JpaRepository<CropPlan, Integer> {
}