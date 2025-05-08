package com.agroconnect.fms_api.repository;

import com.agroconnect.fms_api.model.SalesRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRecordRepository extends JpaRepository<SalesRecord, Integer> {
}