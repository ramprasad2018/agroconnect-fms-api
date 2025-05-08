package com.agroconnect.fms_api.service.impl;

import com.agroconnect.fms_api.dto.FarmActivityLogRequest;
import com.agroconnect.fms_api.dto.FarmActivityLogResponse;
import com.agroconnect.fms_api.mapper.FarmActivityLogMapper;
import com.agroconnect.fms_api.model.FarmActivityLog;
import com.agroconnect.fms_api.repository.FarmActivityLogRepository;
import com.agroconnect.fms_api.service.FarmActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class FarmActivityLogServiceImpl implements FarmActivityLogService {

    private final FarmActivityLogRepository repository;
    private final FarmActivityLogMapper mapper;

    @Override
    public FarmActivityLogResponse create(FarmActivityLogRequest request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }

    @Override
    public FarmActivityLogResponse getById(Integer id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Record not found"));
    }

    @Override
    public List<FarmActivityLogResponse> getAll() {
        return repository.findAll().stream().map(mapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public FarmActivityLogResponse update(Integer id, FarmActivityLogRequest request) {
        FarmActivityLog entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));

        entity.setFarmId(request.getFarmId());
        entity.setActivityDate(request.getActivityDate());
        entity.setActivityType(request.getActivityType());
        entity.setNotes(request.getNotes());
        entity.setStatus(request.getStatus());

        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}