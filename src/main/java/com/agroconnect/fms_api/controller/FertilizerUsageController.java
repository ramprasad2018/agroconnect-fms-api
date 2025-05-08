package com.agroconnect.fms_api.controller;

import com.agroconnect.fms_api.dto.FertilizerUsageRequest;
import com.agroconnect.fms_api.dto.FertilizerUsageResponse;
import com.agroconnect.fms_api.service.FertilizerUsageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fertilizer-usage")
@RequiredArgsConstructor
public class FertilizerUsageController {

    private final FertilizerUsageService service;

    @PostMapping
    public ResponseEntity<FertilizerUsageResponse> create(@RequestBody FertilizerUsageRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FertilizerUsageResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<FertilizerUsageResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<FertilizerUsageResponse> update(@PathVariable Integer id, @RequestBody FertilizerUsageRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}