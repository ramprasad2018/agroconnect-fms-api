package com.agroconnect.fms_api.repository;

import com.agroconnect.fms_api.model.FarmActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmActivityLogRepository extends JpaRepository<FarmActivityLog, Integer> {
}