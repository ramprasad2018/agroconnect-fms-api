package com.agroconnect.fms_api.service;

import com.agroconnect.fms_api.dto.IrrigationScheduleRequest;
import com.agroconnect.fms_api.dto.IrrigationScheduleResponse;

import java.util.List;

public interface IrrigationScheduleService {
    IrrigationScheduleResponse create(IrrigationScheduleRequest request);
    IrrigationScheduleResponse getById(Integer id);
    List<IrrigationScheduleResponse> getAll();
    IrrigationScheduleResponse update(Integer id, IrrigationScheduleRequest request);
    void delete(Integer id);
}
