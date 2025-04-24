package com.agroconnect.fms_api.service;

import com.agroconnect.fms_api.dto.CropPlanRequest;
import com.agroconnect.fms_api.dto.CropPlanResponse;

import java.util.List;

public interface CropPlanService {
    CropPlanResponse create(CropPlanRequest request);
    CropPlanResponse getById(Integer id);
    List<CropPlanResponse> getAll();
    CropPlanResponse update(Integer id, CropPlanRequest request);
    void delete(Integer id);
}