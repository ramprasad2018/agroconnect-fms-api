package com.agroconnect.fms_api.service.impl;

import com.agroconnect.fms_api.dto.PesticideUsageRequest;
import com.agroconnect.fms_api.dto.PesticideUsageResponse;
import com.agroconnect.fms_api.mapper.PesticideUsageMapper;
import com.agroconnect.fms_api.model.PesticideUsage;
import com.agroconnect.fms_api.repository.PesticideUsageRepository;
import com.agroconnect.fms_api.service.PesticideUsageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PesticideUsageServiceImpl implements PesticideUsageService {

    private final PesticideUsageRepository repository;
    private final PesticideUsageMapper mapper;

    @Override
    public PesticideUsageResponse create(PesticideUsageRequest request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }

    @Override
    public PesticideUsageResponse getById(Integer id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Record not found"));
    }

    @Override
    public List<PesticideUsageResponse> getAll() {
        return repository.findAll().stream().map(mapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public PesticideUsageResponse update(Integer id, PesticideUsageRequest request) {
        PesticideUsage entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));

        entity.setFarmId(request.getFarmId());
        entity.setApplicationDate(request.getApplicationDate());
        entity.setPesticideType(request.getPesticideType());
        entity.setQuantity(request.getQuantity());
        entity.setTargetPest(request.getTargetPest());

        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}