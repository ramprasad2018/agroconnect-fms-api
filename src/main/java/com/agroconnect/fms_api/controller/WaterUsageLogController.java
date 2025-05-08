package com.agroconnect.fms_api.controller;

import com.agroconnect.fms_api.dto.WaterUsageLogRequest;
import com.agroconnect.fms_api.dto.WaterUsageLogResponse;
import com.agroconnect.fms_api.service.WaterUsageLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/water-usage")
@RequiredArgsConstructor
public class WaterUsageLogController {

    private final WaterUsageLogService service;

    @PostMapping
    public ResponseEntity<WaterUsageLogResponse> create(@RequestBody WaterUsageLogRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<WaterUsageLogResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<WaterUsageLogResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<WaterUsageLogResponse> update(@PathVariable Integer id, @RequestBody WaterUsageLogRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}