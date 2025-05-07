package com.agroconnect.fms_api.repository;

import com.agroconnect.fms_api.model.DiseasePestRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiseasePestRecordRepository extends JpaRepository<DiseasePestRecord, Integer> {
}