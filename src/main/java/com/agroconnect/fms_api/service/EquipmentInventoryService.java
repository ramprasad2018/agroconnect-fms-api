package com.agroconnect.fms_api.service;

import com.agroconnect.fms_api.dto.EquipmentInventoryRequest;
import com.agroconnect.fms_api.dto.EquipmentInventoryResponse;
import java.util.List;

public interface EquipmentInventoryService {
    EquipmentInventoryResponse create(EquipmentInventoryRequest request);
    EquipmentInventoryResponse getById(Integer id);
    List<EquipmentInventoryResponse> getAll();
    EquipmentInventoryResponse update(Integer id, EquipmentInventoryRequest request);
    void delete(Integer id);
}