package com.agroconnect.fms_api.repository;

import com.agroconnect.fms_api.model.WaterUsageLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaterUsageLogRepository extends JpaRepository<WaterUsageLog, Integer> {
}