package com.agroconnect.fms_api.service;

import com.agroconnect.fms_api.dto.FarmRevenueRequest;
import com.agroconnect.fms_api.dto.FarmRevenueResponse;

import java.util.List;

public interface FarmRevenueService {
    FarmRevenueResponse create(FarmRevenueRequest request);
    FarmRevenueResponse getById(Integer id);
    List<FarmRevenueResponse> getAll();
    FarmRevenueResponse update(Integer id, FarmRevenueRequest request);
    void delete(Integer id);
}