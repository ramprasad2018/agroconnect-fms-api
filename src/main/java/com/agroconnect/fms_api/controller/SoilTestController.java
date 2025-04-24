package com.agroconnect.fms_api.controller;

import com.agroconnect.fms_api.dto.SoilTestRequest;
import com.agroconnect.fms_api.dto.SoilTestResponse;
import com.agroconnect.fms_api.service.SoilTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/soil-tests")
@RequiredArgsConstructor
public class SoilTestController {

    private final SoilTestService service;

    @PostMapping
    public SoilTestResponse create(@RequestBody SoilTestRequest request) {
        return service.createSoilTest(request);
    }

    @GetMapping("/{id}")
    public SoilTestResponse getById(@PathVariable Integer id) {
        return service.getSoilTestById(id);
    }

    @GetMapping("/farm/{farmId}")
    public List<SoilTestResponse> getByFarm(@PathVariable Integer farmId) {
        return service.getSoilTestsByFarmId(farmId);
    }

    @PutMapping("/{id}")
    public SoilTestResponse update(@PathVariable Integer id, @RequestBody SoilTestRequest request) {
        return service.updateSoilTest(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteSoilTest(id);
    }
}