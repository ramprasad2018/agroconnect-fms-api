package com.agroconnect.fms_api.mapper;

import com.agroconnect.fms_api.dto.EquipmentInventoryRequest;
import com.agroconnect.fms_api.dto.EquipmentInventoryResponse;
import com.agroconnect.fms_api.model.EquipmentInventory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EquipmentInventoryMapper {
    EquipmentInventory toEntity(EquipmentInventoryRequest request);
    EquipmentInventoryResponse toResponse(EquipmentInventory entity);
}