package com.agroconnect.fms_api.controller;

import com.agroconnect.fms_api.dto.FarmerRequest;
import com.agroconnect.fms_api.dto.FarmerResponse;
import com.agroconnect.fms_api.service.FarmerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/farmers")
@RequiredArgsConstructor
public class FarmerController {

    private final FarmerService farmerService;

    @PostMapping
    public FarmerResponse createFarmer(@RequestBody FarmerRequest request) {
        return farmerService.createFarmer(request);
    }

    @GetMapping("/{id}")
    public FarmerResponse getFarmerById(@PathVariable Integer id) {
        return farmerService.getFarmerById(id);
    }

    @PutMapping("/{id}")
    public FarmerResponse updateFarmer(@PathVariable Integer id, @RequestBody FarmerRequest request) {
        return farmerService.updateFarmer(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteFarmer(@PathVariable Integer id) {
        farmerService.deleteFarmer(id);
    }

    @GetMapping
    public List<FarmerResponse> getAllFarmers() {
        return farmerService.getAllFarmers();
    }
}
