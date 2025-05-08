package com.agroconnect.fms_api.controller;

import com.agroconnect.fms_api.dto.LabourRecordRequest;
import com.agroconnect.fms_api.dto.LabourRecordResponse;
import com.agroconnect.fms_api.service.LabourRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/labour-records")
@RequiredArgsConstructor
public class LabourRecordController {

    private final LabourRecordService service;

    @PostMapping
    public ResponseEntity<LabourRecordResponse> create(@RequestBody LabourRecordRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LabourRecordResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<LabourRecordResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<LabourRecordResponse> update(@PathVariable Integer id, @RequestBody LabourRecordRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}