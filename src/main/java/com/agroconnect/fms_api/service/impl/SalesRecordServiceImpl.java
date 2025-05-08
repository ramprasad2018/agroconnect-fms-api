package com.agroconnect.fms_api.service.impl;

import com.agroconnect.fms_api.dto.SalesRecordRequest;
import com.agroconnect.fms_api.dto.SalesRecordResponse;
import com.agroconnect.fms_api.mapper.SalesRecordMapper;
import com.agroconnect.fms_api.model.SalesRecord;
import com.agroconnect.fms_api.repository.SalesRecordRepository;
import com.agroconnect.fms_api.service.SalesRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class SalesRecordServiceImpl implements SalesRecordService {

    private final SalesRecordRepository repository;
    private final SalesRecordMapper mapper;

    @Override
    public SalesRecordResponse create(SalesRecordRequest request) {
        SalesRecord entity = mapper.toEntity(request);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public SalesRecordResponse getById(Integer id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Record not found"));
    }

    @Override
    public List<SalesRecordResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public SalesRecordResponse update(Integer id, SalesRecordRequest request) {
        SalesRecord existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));

        existing.setFarmId(request.getFarmId());
        existing.setSaleDate(request.getSaleDate());
        existing.setCrop(request.getCrop());
        existing.setQuantity(request.getQuantity());
        existing.setPricePerUnit(request.getPricePerUnit());
        existing.setBuyerName(request.getBuyerName());
        existing.setSaleChannel(request.getSaleChannel());

        return mapper.toResponse(repository.save(existing));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}