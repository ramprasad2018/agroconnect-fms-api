package com.agroconnect.fms_api.controller;

import com.agroconnect.fms_api.dto.WeatherForecastRequest;
import com.agroconnect.fms_api.dto.WeatherForecastResponse;
import com.agroconnect.fms_api.service.WeatherForecastService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/weather-forecast")
@RequiredArgsConstructor
public class WeatherForecastController {

    private final WeatherForecastService service;

    @PostMapping
    public ResponseEntity<WeatherForecastResponse> create(@RequestBody WeatherForecastRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<WeatherForecastResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<WeatherForecastResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<WeatherForecastResponse> update(@PathVariable Integer id, @RequestBody WeatherForecastRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}