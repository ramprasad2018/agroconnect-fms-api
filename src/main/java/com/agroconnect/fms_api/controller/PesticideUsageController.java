package com.agroconnect.fms_api.controller;

import com.agroconnect.fms_api.dto.PesticideUsageRequest;
import com.agroconnect.fms_api.dto.PesticideUsageResponse;
import com.agroconnect.fms_api.service.PesticideUsageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pesticide-usage")
@RequiredArgsConstructor
public class PesticideUsageController {

    private final PesticideUsageService service;

    @PostMapping
    public ResponseEntity<PesticideUsageResponse> create(@RequestBody PesticideUsageRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PesticideUsageResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<PesticideUsageResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PesticideUsageResponse> update(@PathVariable Integer id, @RequestBody PesticideUsageRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}