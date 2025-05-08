package com.agroconnect.fms_api.service.impl;

import com.agroconnect.fms_api.dto.FertilizerUsageRequest;
import com.agroconnect.fms_api.dto.FertilizerUsageResponse;
import com.agroconnect.fms_api.mapper.FertilizerUsageMapper;
import com.agroconnect.fms_api.model.FertilizerUsage;
import com.agroconnect.fms_api.repository.FertilizerUsageRepository;
import com.agroconnect.fms_api.service.FertilizerUsageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class FertilizerUsageServiceImpl implements FertilizerUsageService {

    private final FertilizerUsageRepository repository;
    private final FertilizerUsageMapper mapper;

    @Override
    public FertilizerUsageResponse create(FertilizerUsageRequest request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }

    @Override
    public FertilizerUsageResponse getById(Integer id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Record not found"));
    }

    @Override
    public List<FertilizerUsageResponse> getAll() {
        return repository.findAll().stream().map(mapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public FertilizerUsageResponse update(Integer id, FertilizerUsageRequest request) {
        FertilizerUsage entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));

        entity.setFarmId(request.getFarmId());
        entity.setApplicationDate(request.getApplicationDate());
        entity.setFertilizerType(request.getFertilizerType());
        entity.setQuantity(request.getQuantity());
        entity.setApplicationMethod(request.getApplicationMethod());

        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}