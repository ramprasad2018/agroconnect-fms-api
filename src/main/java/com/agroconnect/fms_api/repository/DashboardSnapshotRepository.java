package com.agroconnect.fms_api.repository;

import com.agroconnect.fms_api.model.DashboardSnapshot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardSnapshotRepository extends JpaRepository<DashboardSnapshot, Integer> {
}