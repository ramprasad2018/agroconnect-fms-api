package com.agroconnect.fms_api.repository;

import com.agroconnect.fms_api.model.IrrigationSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IrrigationScheduleRepository extends JpaRepository<IrrigationSchedule, Integer> {
}
