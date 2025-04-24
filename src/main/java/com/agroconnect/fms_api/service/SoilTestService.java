package com.agroconnect.fms_api.service;

import com.agroconnect.fms_api.dto.SoilTestRequest;
import com.agroconnect.fms_api.dto.SoilTestResponse;

import java.util.List;

public interface SoilTestService {
    SoilTestResponse createSoilTest(SoilTestRequest request);
    SoilTestResponse getSoilTestById(Integer id);
    List<SoilTestResponse> getSoilTestsByFarmId(Integer farmId);
    SoilTestResponse updateSoilTest(Integer id, SoilTestRequest request);
    void deleteSoilTest(Integer id);
}