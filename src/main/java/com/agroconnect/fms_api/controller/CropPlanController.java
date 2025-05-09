package com.agroconnect.fms_api.controller;

import com.agroconnect.fms_api.dto.CropPlanRequest;
import com.agroconnect.fms_api.dto.CropPlanResponse;
import com.agroconnect.fms_api.service.CropPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// Crop Planning Controller
// This controller handles all the endpoints related to crop planning
// It allows users to create, read, update, and delete crop plans
// The endpoints are defined using Spring's @RestController and @RequestMapping annotations
@RestController
@RequestMapping("/api/crop-plans")
public class CropPlanController {

    @Autowired
    private CropPlanService cropPlanService;

    @PostMapping
    public ResponseEntity<CropPlanResponse> create(@RequestBody CropPlanRequest request) {
        return ResponseEntity.ok(cropPlanService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CropPlanResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(cropPlanService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<CropPlanResponse>> getAll() {
        return ResponseEntity.ok(cropPlanService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CropPlanResponse> update(@PathVariable Integer id, @RequestBody CropPlanRequest request) {
        return ResponseEntity.ok(cropPlanService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        cropPlanService.delete(id);
        return ResponseEntity.noContent().build();
    }
}