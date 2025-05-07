package com.agroconnect.fms_api.controller;

import com.agroconnect.fms_api.dto.IrrigationScheduleRequest;
import com.agroconnect.fms_api.dto.IrrigationScheduleResponse;
import com.agroconnect.fms_api.service.IrrigationScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/irrigation-schedules")
@RequiredArgsConstructor
public class IrrigationScheduleController {

    private final IrrigationScheduleService service;

    @PostMapping
    public ResponseEntity<IrrigationScheduleResponse> create(@RequestBody IrrigationScheduleRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<IrrigationScheduleResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<IrrigationScheduleResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<IrrigationScheduleResponse> update(@PathVariable Integer id,
                                                              @RequestBody IrrigationScheduleRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
