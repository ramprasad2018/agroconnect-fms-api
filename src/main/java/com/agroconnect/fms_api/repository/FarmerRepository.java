package com.agroconnect.fms_api.repository;

import com.agroconnect.fms_api.model.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmerRepository extends JpaRepository<Farmer, Integer> {
}
