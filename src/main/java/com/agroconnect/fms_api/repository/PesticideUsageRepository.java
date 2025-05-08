package com.agroconnect.fms_api.repository;

import com.agroconnect.fms_api.model.PesticideUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PesticideUsageRepository extends JpaRepository<PesticideUsage, Integer> {
}