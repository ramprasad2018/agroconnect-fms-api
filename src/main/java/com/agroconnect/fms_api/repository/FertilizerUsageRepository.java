package com.agroconnect.fms_api.repository;

import com.agroconnect.fms_api.model.FertilizerUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FertilizerUsageRepository extends JpaRepository<FertilizerUsage, Integer> {
}