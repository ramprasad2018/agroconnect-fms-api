package com.agroconnect.fms_api.service.impl;

import com.agroconnect.fms_api.dto.EquipmentInventoryRequest;
import com.agroconnect.fms_api.dto.EquipmentInventoryResponse;
import com.agroconnect.fms_api.mapper.EquipmentInventoryMapper;
import com.agroconnect.fms_api.model.EquipmentInventory;
import com.agroconnect.fms_api.repository.EquipmentInventoryRepository;
import com.agroconnect.fms_api.service.EquipmentInventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class EquipmentInventoryServiceImpl implements EquipmentInventoryService {

    private final EquipmentInventoryRepository repository;
    private final EquipmentInventoryMapper mapper;

    @Override
    public EquipmentInventoryResponse create(EquipmentInventoryRequest request) {
        EquipmentInventory entity = mapper.toEntity(request);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public EquipmentInventoryResponse getById(Integer id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Equipment not found"));
    }

    @Override
    public List<EquipmentInventoryResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public EquipmentInventoryResponse update(Integer id, EquipmentInventoryRequest request) {
        EquipmentInventory existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipment not found"));

        existing.setFarmId(request.getFarmId());
        existing.setEquipmentName(request.getEquipmentName());
        existing.setQuantity(request.getQuantity());
        existing.setCondition(request.getCondition());
        existing.setPurchaseDate(request.getPurchaseDate());
        existing.setMaintenanceDate(request.getMaintenanceDate());
        existing.setStatus(request.getStatus());

        return mapper.toResponse(repository.save(existing));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}