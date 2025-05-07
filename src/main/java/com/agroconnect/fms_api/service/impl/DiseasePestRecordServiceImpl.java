package com.agroconnect.fms_api.service.impl;

import com.agroconnect.fms_api.dto.DiseasePestRecordRequest;
import com.agroconnect.fms_api.dto.DiseasePestRecordResponse;
import com.agroconnect.fms_api.mapper.DiseasePestRecordMapper;
import com.agroconnect.fms_api.model.DiseasePestRecord;
import com.agroconnect.fms_api.repository.DiseasePestRecordRepository;
import com.agroconnect.fms_api.service.DiseasePestRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class DiseasePestRecordServiceImpl implements DiseasePestRecordService {

    private final DiseasePestRecordRepository repository;
    private final DiseasePestRecordMapper mapper;

    @Override
    public DiseasePestRecordResponse create(DiseasePestRecordRequest request) {
        DiseasePestRecord entity = mapper.toEntity(request);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public DiseasePestRecordResponse getById(Integer id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Record not found"));
    }

    @Override
    public List<DiseasePestRecordResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public DiseasePestRecordResponse update(Integer id, DiseasePestRecordRequest request) {
        DiseasePestRecord existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));

        existing.setFarmId(request.getFarmId());
        existing.setReportDate(request.getReportDate());
        existing.setIssueType(request.getIssueType());
        existing.setSeverity(request.getSeverity());
        existing.setNotes(request.getNotes());
        existing.setActionTaken(request.getActionTaken());

        return mapper.toResponse(repository.save(existing));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}