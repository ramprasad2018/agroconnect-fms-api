package com.agroconnect.fms_api.repository;

import com.agroconnect.fms_api.model.HarvestRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HarvestRecordRepository extends JpaRepository<HarvestRecord, Integer> {
}