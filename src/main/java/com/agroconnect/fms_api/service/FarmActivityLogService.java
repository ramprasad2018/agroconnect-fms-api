package com.agroconnect.fms_api.service;

import com.agroconnect.fms_api.dto.FarmActivityLogRequest;
import com.agroconnect.fms_api.dto.FarmActivityLogResponse;

import java.util.List;

public interface FarmActivityLogService {
    FarmActivityLogResponse create(FarmActivityLogRequest request);
    FarmActivityLogResponse getById(Integer id);
    List<FarmActivityLogResponse> getAll();
    FarmActivityLogResponse update(Integer id, FarmActivityLogRequest request);
    void delete(Integer id);
}