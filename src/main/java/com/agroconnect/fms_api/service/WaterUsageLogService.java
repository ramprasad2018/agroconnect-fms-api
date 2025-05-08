package com.agroconnect.fms_api.service;

import com.agroconnect.fms_api.dto.WaterUsageLogRequest;
import com.agroconnect.fms_api.dto.WaterUsageLogResponse;

import java.util.List;

public interface WaterUsageLogService {
    WaterUsageLogResponse create(WaterUsageLogRequest request);
    WaterUsageLogResponse getById(Integer id);
    List<WaterUsageLogResponse> getAll();
    WaterUsageLogResponse update(Integer id, WaterUsageLogRequest request);
    void delete(Integer id);
}