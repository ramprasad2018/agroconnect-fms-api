package com.agroconnect.fms_api.service;

import com.agroconnect.fms_api.dto.FertilizerUsageRequest;
import com.agroconnect.fms_api.dto.FertilizerUsageResponse;

import java.util.List;

public interface FertilizerUsageService {
    FertilizerUsageResponse create(FertilizerUsageRequest request);
    FertilizerUsageResponse getById(Integer id);
    List<FertilizerUsageResponse> getAll();
    FertilizerUsageResponse update(Integer id, FertilizerUsageRequest request);
    void delete(Integer id);
}