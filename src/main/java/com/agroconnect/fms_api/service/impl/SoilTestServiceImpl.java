package com.agroconnect.fms_api.service.impl;

import com.agroconnect.fms_api.dto.SoilTestRequest;
import com.agroconnect.fms_api.dto.SoilTestResponse;
import com.agroconnect.fms_api.model.SoilTest;
import com.agroconnect.fms_api.repository.SoilTestRepository;
import com.agroconnect.fms_api.service.SoilTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SoilTestServiceImpl implements SoilTestService {

    private final SoilTestRepository repository;

    @Override
    public SoilTestResponse createSoilTest(SoilTestRequest request) {
        SoilTest soilTest = SoilTest.builder()
                .farmId(request.getFarmId())
                .testDate(request.getTestDate())
                .phLevel(request.getPhLevel())
                .nitrogenLevel(request.getNitrogenLevel())
                .phosphorusLevel(request.getPhosphorusLevel())
                .potassiumLevel(request.getPotassiumLevel())
                .organicMatter(request.getOrganicMatter())
                .recommendations(request.getRecommendations())
                .createdAt(LocalDateTime.now())
                .build();
        return toResponse(repository.save(soilTest));
    }

    @Override
    public SoilTestResponse getSoilTestById(Integer id) {
        SoilTest soilTest = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Soil Test not found"));
        return toResponse(soilTest);
    }

    @Override
    public List<SoilTestResponse> getSoilTestsByFarmId(Integer farmId) {
        return repository.findByFarmId(farmId).stream().map(this::toResponse).collect(Collectors.toList());
    }

    @Override
    public SoilTestResponse updateSoilTest(Integer id, SoilTestRequest request) {
        SoilTest soilTest = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Soil Test not found"));

        soilTest.setTestDate(request.getTestDate());
        soilTest.setPhLevel(request.getPhLevel());
        soilTest.setNitrogenLevel(request.getNitrogenLevel());
        soilTest.setPhosphorusLevel(request.getPhosphorusLevel());
        soilTest.setPotassiumLevel(request.getPotassiumLevel());
        soilTest.setOrganicMatter(request.getOrganicMatter());
        soilTest.setRecommendations(request.getRecommendations());

        return toResponse(repository.save(soilTest));
    }

    @Override
    public void deleteSoilTest(Integer id) {
        repository.deleteById(id);
    }

    private SoilTestResponse toResponse(SoilTest soilTest) {
        return SoilTestResponse.builder()
                .id(soilTest.getId())
                .farmId(soilTest.getFarmId())
                .testDate(soilTest.getTestDate())
                .phLevel(soilTest.getPhLevel())
                .nitrogenLevel(soilTest.getNitrogenLevel())
                .phosphorusLevel(soilTest.getPhosphorusLevel())
                .potassiumLevel(soilTest.getPotassiumLevel())
                .organicMatter(soilTest.getOrganicMatter())
                .recommendations(soilTest.getRecommendations())
                .createdAt(soilTest.getCreatedAt())
                .build();
    }
}