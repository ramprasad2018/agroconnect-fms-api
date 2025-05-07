package com.agroconnect.fms_api.controller;

import com.agroconnect.fms_api.dto.DiseasePestRecordRequest;
import com.agroconnect.fms_api.dto.DiseasePestRecordResponse;
import com.agroconnect.fms_api.service.DiseasePestRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disease-pest")
@RequiredArgsConstructor
public class DiseasePestRecordController {

    private final DiseasePestRecordService service;

    @PostMapping
    public ResponseEntity<DiseasePestRecordResponse> create(@RequestBody DiseasePestRecordRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiseasePestRecordResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<DiseasePestRecordResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiseasePestRecordResponse> update(@PathVariable Integer id, @RequestBody DiseasePestRecordRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}