package com.agroconnect.fms_api.service.impl;

import com.agroconnect.fms_api.dto.HarvestRecordRequest;
import com.agroconnect.fms_api.dto.HarvestRecordResponse;
import com.agroconnect.fms_api.mapper.HarvestRecordMapper;
import com.agroconnect.fms_api.model.HarvestRecord;
import com.agroconnect.fms_api.repository.HarvestRecordRepository;
import com.agroconnect.fms_api.service.HarvestRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class HarvestRecordServiceImpl implements HarvestRecordService {

    private final HarvestRecordRepository repository;
    private final HarvestRecordMapper mapper;

    @Override
    public HarvestRecordResponse create(HarvestRecordRequest request) {
        HarvestRecord entity = mapper.toEntity(request);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public HarvestRecordResponse getById(Integer id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Record not found"));
    }

    @Override
    public List<HarvestRecordResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public HarvestRecordResponse update(Integer id, HarvestRecordRequest request) {
        HarvestRecord existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));

        existing.setFarmId(request.getFarmId());
        existing.setHarvestDate(request.getHarvestDate());
        existing.setCrop(request.getCrop());
        existing.setYieldQuantity(request.getYieldQuantity());
        existing.setQualityGrade(request.getQualityGrade());
        existing.setSellingPrice(request.getSellingPrice());

        return mapper.toResponse(repository.save(existing));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}