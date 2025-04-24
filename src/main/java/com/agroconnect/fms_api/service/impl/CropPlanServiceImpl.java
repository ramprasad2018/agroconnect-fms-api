package com.agroconnect.fms_api.service.impl;

import com.agroconnect.fms_api.dto.CropPlanRequest;
import com.agroconnect.fms_api.dto.CropPlanResponse;
import com.agroconnect.fms_api.model.CropPlan;
import com.agroconnect.fms_api.repository.CropPlanRepository;
import com.agroconnect.fms_api.service.CropPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CropPlanServiceImpl implements CropPlanService {

    @Autowired
    private CropPlanRepository cropPlanRepository;

    @Override
    public CropPlanResponse create(CropPlanRequest request) {
        CropPlan plan = new CropPlan(null, request.getFarmId(), request.getCropName(),
                request.getPlantingDate(), request.getExpectedHarvestDate(),
                request.getSeedType(), request.getFertilizerPlan(), request.getNotes(), null);
        return toResponse(cropPlanRepository.save(plan));
    }

    @Override
    public CropPlanResponse getById(Integer id) {
        CropPlan plan = cropPlanRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Crop plan not found"));
        return toResponse(plan);
    }

    @Override
    public List<CropPlanResponse> getAll() {
        return cropPlanRepository.findAll().stream().map(this::toResponse).collect(Collectors.toList());
    }

    @Override
    public CropPlanResponse update(Integer id, CropPlanRequest request) {
        CropPlan plan = cropPlanRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Crop plan not found"));
        plan.setCropName(request.getCropName());
        plan.setPlantingDate(request.getPlantingDate());
        plan.setExpectedHarvestDate(request.getExpectedHarvestDate());
        plan.setSeedType(request.getSeedType());
        plan.setFertilizerPlan(request.getFertilizerPlan());
        plan.setNotes(request.getNotes());
        return toResponse(cropPlanRepository.save(plan));
    }

    @Override
    public void delete(Integer id) {
        cropPlanRepository.deleteById(id);
    }

    private CropPlanResponse toResponse(CropPlan plan) {
        return CropPlanResponse.builder()
                .id(plan.getId())
                .farmId(plan.getFarmId())
                .cropName(plan.getCropName())
                .plantingDate(plan.getPlantingDate())
                .expectedHarvestDate(plan.getExpectedHarvestDate())
                .seedType(plan.getSeedType())
                .fertilizerPlan(plan.getFertilizerPlan())
                .notes(plan.getNotes())
                .build();
    }
}