package com.agroconnect.fms_api.controller;

import com.agroconnect.fms_api.dto.EquipmentInventoryRequest;
import com.agroconnect.fms_api.dto.EquipmentInventoryResponse;
import com.agroconnect.fms_api.service.EquipmentInventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipment-inventory")
@RequiredArgsConstructor
public class EquipmentInventoryController {

    private final EquipmentInventoryService service;

    @PostMapping
    public ResponseEntity<EquipmentInventoryResponse> create(@RequestBody EquipmentInventoryRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipmentInventoryResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<EquipmentInventoryResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipmentInventoryResponse> update(@PathVariable Integer id, @RequestBody EquipmentInventoryRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}