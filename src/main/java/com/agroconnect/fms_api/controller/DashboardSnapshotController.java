package com.agroconnect.fms_api.controller;

import com.agroconnect.fms_api.dto.DashboardSnapshotRequest;
import com.agroconnect.fms_api.dto.DashboardSnapshotResponse;
import com.agroconnect.fms_api.service.DashboardSnapshotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard-snapshots")
@RequiredArgsConstructor
public class DashboardSnapshotController {

    private final DashboardSnapshotService service;

    @PostMapping
    public ResponseEntity<DashboardSnapshotResponse> create(@RequestBody DashboardSnapshotRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DashboardSnapshotResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<DashboardSnapshotResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DashboardSnapshotResponse> update(@PathVariable Integer id, @RequestBody DashboardSnapshotRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}