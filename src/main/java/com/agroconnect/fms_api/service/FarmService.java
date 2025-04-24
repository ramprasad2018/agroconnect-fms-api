package com.agroconnect.fms_api.service;

import com.agroconnect.fms_api.dto.FarmRequest;
import com.agroconnect.fms_api.dto.FarmResponse;

import java.util.List;

public interface FarmService {
    FarmResponse createFarm(FarmRequest request);
    FarmResponse getFarmById(Integer id);
    List<FarmResponse> getFarmsByFarmerId(Integer farmerId);
    FarmResponse updateFarm(Integer id, FarmRequest request);
    void deleteFarm(Integer id);
}
