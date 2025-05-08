package com.agroconnect.fms_api.service.impl;

import com.agroconnect.fms_api.dto.WaterUsageLogRequest;
import com.agroconnect.fms_api.dto.WaterUsageLogResponse;
import com.agroconnect.fms_api.mapper.WaterUsageLogMapper;
import com.agroconnect.fms_api.model.WaterUsageLog;
import com.agroconnect.fms_api.repository.WaterUsageLogRepository;
import com.agroconnect.fms_api.service.WaterUsageLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class WaterUsageLogServiceImpl implements WaterUsageLogService {

    private final WaterUsageLogRepository repository;
    private final WaterUsageLogMapper mapper;

    @Override
    public WaterUsageLogResponse create(WaterUsageLogRequest request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }

    @Override
    public WaterUsageLogResponse getById(Integer id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Record not found"));
    }

    @Override
    public List<WaterUsageLogResponse> getAll() {
        return repository.findAll().stream().map(mapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public WaterUsageLogResponse update(Integer id, WaterUsageLogRequest request) {
        WaterUsageLog entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));

        entity.setFarmId(request.getFarmId());
        entity.setUsageDate(request.getUsageDate());
        entity.setLitersUsed(request.getLitersUsed());

        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}