package com.agroconnect.fms_api.controller;

import com.agroconnect.fms_api.dto.FarmRequest;
import com.agroconnect.fms_api.dto.FarmResponse;
import com.agroconnect.fms_api.service.FarmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/farms")
@RequiredArgsConstructor
public class FarmController {

    private final FarmService farmService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FarmResponse createFarm(@RequestBody FarmRequest request) {
        return farmService.createFarm(request);
    }

    @GetMapping("/{id}")
    public FarmResponse getFarmById(@PathVariable Integer id) {
        return farmService.getFarmById(id);
    }

    @GetMapping("/farmer/{farmerId}")
    public List<FarmResponse> getFarmsByFarmerId(@PathVariable Integer farmerId) {
        return farmService.getFarmsByFarmerId(farmerId);
    }

    @PutMapping("/{id}")
    public FarmResponse updateFarm(@PathVariable Integer id, @RequestBody FarmRequest request) {
        return farmService.updateFarm(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFarm(@PathVariable Integer id) {
        farmService.deleteFarm(id);
    }
}
