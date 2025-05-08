package com.agroconnect.fms_api.controller;

import com.agroconnect.fms_api.dto.FarmExpenseRequest;
import com.agroconnect.fms_api.dto.FarmExpenseResponse;
import com.agroconnect.fms_api.service.FarmExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/farm-expense")
@RequiredArgsConstructor
public class FarmExpenseController {

    private final FarmExpenseService service;

    @PostMapping
    public ResponseEntity<FarmExpenseResponse> create(@RequestBody FarmExpenseRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FarmExpenseResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<FarmExpenseResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<FarmExpenseResponse> update(@PathVariable Integer id, @RequestBody FarmExpenseRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}