package com.agroconnect.fms_api.controller;

import com.agroconnect.fms_api.dto.FarmActivityLogRequest;
import com.agroconnect.fms_api.dto.FarmActivityLogResponse;
import com.agroconnect.fms_api.service.FarmActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/farm-activity")
@RequiredArgsConstructor
public class FarmActivityLogController {

    private final FarmActivityLogService service;

    @PostMapping
    public ResponseEntity<FarmActivityLogResponse> create(@RequestBody FarmActivityLogRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FarmActivityLogResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<FarmActivityLogResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<FarmActivityLogResponse> update(@PathVariable Integer id, @RequestBody FarmActivityLogRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}