package com.agroconnect.fms_api.service;

import com.agroconnect.fms_api.dto.FarmerRequest;
import com.agroconnect.fms_api.dto.FarmerResponse;

import java.util.List;

public interface FarmerService {
    FarmerResponse createFarmer(FarmerRequest request);
    FarmerResponse getFarmerById(Integer id);
    FarmerResponse updateFarmer(Integer id, FarmerRequest request);
    void deleteFarmer(Integer id);
    List<FarmerResponse> getAllFarmers();
}
