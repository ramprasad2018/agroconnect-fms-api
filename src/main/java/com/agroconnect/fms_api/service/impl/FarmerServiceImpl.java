package com.agroconnect.fms_api.service.impl;

import com.agroconnect.fms_api.dto.FarmerRequest;
import com.agroconnect.fms_api.dto.FarmerResponse;
import com.agroconnect.fms_api.model.Farmer;
import com.agroconnect.fms_api.repository.FarmerRepository;
import com.agroconnect.fms_api.service.FarmerService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FarmerServiceImpl implements FarmerService {

    private final FarmerRepository farmerRepository;

    @Override
    public FarmerResponse createFarmer(FarmerRequest request) {
        Farmer farmer = Farmer.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .type(request.getType())
                .createdAt(LocalDateTime.now())
                .build();
        return toResponse(farmerRepository.save(farmer));
    }

    @Override
    public FarmerResponse getFarmerById(Integer id) {
        Farmer farmer = farmerRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Farmer not found"));
        return toResponse(farmer);
    }
    
    @Override
    public FarmerResponse updateFarmer(Integer id, FarmerRequest request) {
        Farmer farmer = farmerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Farmer not found"));

        farmer.setName(request.getName());
        farmer.setEmail(request.getEmail());
        farmer.setPhone(request.getPhone());
        farmer.setType(request.getType());

        return toResponse(farmerRepository.save(farmer));
    }

    @Override
    public void deleteFarmer(Integer id) {
        farmerRepository.deleteById(id);
    }

    @Override
    public List<FarmerResponse> getAllFarmers() {
        return farmerRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private FarmerResponse toResponse(Farmer farmer) {
        return FarmerResponse.builder()
                .id(farmer.getId())
                .name(farmer.getName())
                .email(farmer.getEmail())
                .phone(farmer.getPhone())
                .type(farmer.getType())
                .build();
    }
}
