package com.agroconnect.fms_api.service.impl;

import com.agroconnect.fms_api.dto.FarmRevenueRequest;
import com.agroconnect.fms_api.dto.FarmRevenueResponse;
import com.agroconnect.fms_api.mapper.FarmRevenueMapper;
import com.agroconnect.fms_api.model.FarmRevenue;
import com.agroconnect.fms_api.repository.FarmRevenueRepository;
import com.agroconnect.fms_api.service.FarmRevenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class FarmRevenueServiceImpl implements FarmRevenueService {

    private final FarmRevenueRepository repository;
    private final FarmRevenueMapper mapper;

    @Override
    public FarmRevenueResponse create(FarmRevenueRequest request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }

    @Override
    public FarmRevenueResponse getById(Integer id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Record not found"));
    }

    @Override
    public List<FarmRevenueResponse> getAll() {
        return repository.findAll().stream().map(mapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public FarmRevenueResponse update(Integer id, FarmRevenueRequest request) {
        FarmRevenue entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));

        entity.setFarmId(request.getFarmId());
        entity.setRevenueDate(request.getRevenueDate());
        entity.setSource(request.getSource());
        entity.setAmount(request.getAmount());
        entity.setPaymentReceivedDate(request.getPaymentReceivedDate());

        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}