package com.agroconnect.fms_api.controller;

import com.agroconnect.fms_api.dto.HarvestRecordRequest;
import com.agroconnect.fms_api.dto.HarvestRecordResponse;
import com.agroconnect.fms_api.service.HarvestRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/harvest-records")
@RequiredArgsConstructor
public class HarvestRecordController {

    private final HarvestRecordService service;

    @PostMapping
    public ResponseEntity<HarvestRecordResponse> create(@RequestBody HarvestRecordRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HarvestRecordResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<HarvestRecordResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<HarvestRecordResponse> update(@PathVariable Integer id, @RequestBody HarvestRecordRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}