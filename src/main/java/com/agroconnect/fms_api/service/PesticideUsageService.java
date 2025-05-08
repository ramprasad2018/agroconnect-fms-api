package com.agroconnect.fms_api.service;

import com.agroconnect.fms_api.dto.PesticideUsageRequest;
import com.agroconnect.fms_api.dto.PesticideUsageResponse;

import java.util.List;

public interface PesticideUsageService {
    PesticideUsageResponse create(PesticideUsageRequest request);
    PesticideUsageResponse getById(Integer id);
    List<PesticideUsageResponse> getAll();
    PesticideUsageResponse update(Integer id, PesticideUsageRequest request);
    void delete(Integer id);
}