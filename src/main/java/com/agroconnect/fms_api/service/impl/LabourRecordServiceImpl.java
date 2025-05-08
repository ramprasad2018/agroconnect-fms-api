package com.agroconnect.fms_api.service.impl;

import com.agroconnect.fms_api.dto.LabourRecordRequest;
import com.agroconnect.fms_api.dto.LabourRecordResponse;
import com.agroconnect.fms_api.mapper.LabourRecordMapper;
import com.agroconnect.fms_api.model.LabourRecord;
import com.agroconnect.fms_api.repository.LabourRecordRepository;
import com.agroconnect.fms_api.service.LabourRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class LabourRecordServiceImpl implements LabourRecordService {

    private final LabourRecordRepository repository;
    private final LabourRecordMapper mapper;

    @Override
    public LabourRecordResponse create(LabourRecordRequest request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }

    @Override
    public LabourRecordResponse getById(Integer id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Record not found"));
    }

    @Override
    public List<LabourRecordResponse> getAll() {
        return repository.findAll().stream().map(mapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public LabourRecordResponse update(Integer id, LabourRecordRequest request) {
        LabourRecord entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));

        entity.setFarmId(request.getFarmId());
        entity.setLabourerName(request.getLabourerName());
        entity.setWorkDate(request.getWorkDate());
        entity.setHoursWorked(request.getHoursWorked());
        entity.setTaskDescription(request.getTaskDescription());

        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}