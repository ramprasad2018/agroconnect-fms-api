package com.agroconnect.fms_api.repository;

import com.agroconnect.fms_api.model.LabourRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabourRecordRepository extends JpaRepository<LabourRecord, Integer> {
}