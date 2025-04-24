package com.agroconnect.fms_api.service.impl;

import com.agroconnect.fms_api.dto.FarmRequest;
import com.agroconnect.fms_api.dto.FarmResponse;
import com.agroconnect.fms_api.model.Farm;
import com.agroconnect.fms_api.repository.FarmRepository;
import com.agroconnect.fms_api.service.FarmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FarmServiceImpl implements FarmService {

    private final FarmRepository farmRepository;

    @Override
    public FarmResponse createFarm(FarmRequest request) {
        Farm farm = toEntity(request);
        return toResponse(farmRepository.save(farm));
    }

    @Override
    public FarmResponse getFarmById(Integer id) {
        Farm farm = farmRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Farm not found"));
        return toResponse(farm);
    }

    @Override
    public List<FarmResponse> getFarmsByFarmerId(Integer farmerId) {
        return farmRepository.findByFarmerId(farmerId)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public FarmResponse updateFarm(Integer id, FarmRequest request) {
        Farm farm = farmRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Farm not found"));

        farm.setName(request.getName());
        farm.setLocation(request.getLocation());
        farm.setSizeInAcres(request.getSizeInAcres());
        farm.setCropType(request.getCropType());
        farm.setSoilQuality(request.getSoilQuality());
        farm.setIrrigationType(request.getIrrigationType());

        return toResponse(farmRepository.save(farm));
    }

    @Override
    public void deleteFarm(Integer id) {
        farmRepository.deleteById(id);
    }

    private Farm toEntity(FarmRequest request) {
        return Farm.builder()
                .farmerId(request.getFarmerId())
                .name(request.getName())
                .location(request.getLocation())
                .sizeInAcres(request.getSizeInAcres())
                .cropType(request.getCropType())
                .soilQuality(request.getSoilQuality())
                .irrigationType(request.getIrrigationType())
                .build();
    }

    private FarmResponse toResponse(Farm farm) {
        return FarmResponse.builder()
                .id(farm.getId())
                .farmerId(farm.getFarmerId())
                .name(farm.getName())
                .location(farm.getLocation())
                .sizeInAcres(farm.getSizeInAcres())
                .cropType(farm.getCropType())
                .soilQuality(farm.getSoilQuality())
                .irrigationType(farm.getIrrigationType())
                .createdAt(farm.getCreatedAt())
                .build();
    }
}
