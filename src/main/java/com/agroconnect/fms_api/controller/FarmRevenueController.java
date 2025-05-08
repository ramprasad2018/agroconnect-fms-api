package com.agroconnect.fms_api.controller;

import com.agroconnect.fms_api.dto.FarmRevenueRequest;
import com.agroconnect.fms_api.dto.FarmRevenueResponse;
import com.agroconnect.fms_api.service.FarmRevenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/farm-revenue")
@RequiredArgsConstructor
public class FarmRevenueController {

    private final FarmRevenueService service;

    @PostMapping
    public ResponseEntity<FarmRevenueResponse> create(@RequestBody FarmRevenueRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FarmRevenueResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<FarmRevenueResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<FarmRevenueResponse> update(@PathVariable Integer id, @RequestBody FarmRevenueRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}