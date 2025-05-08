package com.agroconnect.fms_api.service;

import com.agroconnect.fms_api.dto.FarmExpenseRequest;
import com.agroconnect.fms_api.dto.FarmExpenseResponse;

import java.util.List;

public interface FarmExpenseService {
    FarmExpenseResponse create(FarmExpenseRequest request);
    FarmExpenseResponse getById(Integer id);
    List<FarmExpenseResponse> getAll();
    FarmExpenseResponse update(Integer id, FarmExpenseRequest request);
    void delete(Integer id);
}