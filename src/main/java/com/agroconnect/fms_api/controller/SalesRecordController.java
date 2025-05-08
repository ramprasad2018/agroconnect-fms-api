package com.agroconnect.fms_api.controller;

import com.agroconnect.fms_api.dto.SalesRecordRequest;
import com.agroconnect.fms_api.dto.SalesRecordResponse;
import com.agroconnect.fms_api.service.SalesRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales-records")
@RequiredArgsConstructor
public class SalesRecordController {

    private final SalesRecordService service;

    @PostMapping
    public ResponseEntity<SalesRecordResponse> create(@RequestBody SalesRecordRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalesRecordResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<SalesRecordResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalesRecordResponse> update(@PathVariable Integer id, @RequestBody SalesRecordRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}