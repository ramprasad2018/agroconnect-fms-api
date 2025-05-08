package com.agroconnect.fms_api.service.impl;

import com.agroconnect.fms_api.dto.FarmExpenseRequest;
import com.agroconnect.fms_api.dto.FarmExpenseResponse;
import com.agroconnect.fms_api.mapper.FarmExpenseMapper;
import com.agroconnect.fms_api.model.FarmExpense;
import com.agroconnect.fms_api.repository.FarmExpenseRepository;
import com.agroconnect.fms_api.service.FarmExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class FarmExpenseServiceImpl implements FarmExpenseService {

    private final FarmExpenseRepository repository;
    private final FarmExpenseMapper mapper;

    @Override
    public FarmExpenseResponse create(FarmExpenseRequest request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }

    @Override
    public FarmExpenseResponse getById(Integer id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Record not found"));
    }

    @Override
    public List<FarmExpenseResponse> getAll() {
        return repository.findAll().stream().map(mapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public FarmExpenseResponse update(Integer id, FarmExpenseRequest request) {
        FarmExpense entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));

        entity.setFarmId(request.getFarmId());
        entity.setExpenseDate(request.getExpenseDate());
        entity.setExpenseType(request.getExpenseType());
        entity.setAmount(request.getAmount());
        entity.setPaymentMode(request.getPaymentMode());

        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}