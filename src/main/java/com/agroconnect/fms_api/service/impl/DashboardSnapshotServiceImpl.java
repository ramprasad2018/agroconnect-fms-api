package com.agroconnect.fms_api.service.impl;

import com.agroconnect.fms_api.dto.DashboardSnapshotRequest;
import com.agroconnect.fms_api.dto.DashboardSnapshotResponse;
import com.agroconnect.fms_api.mapper.DashboardSnapshotMapper;
import com.agroconnect.fms_api.model.DashboardSnapshot;
import com.agroconnect.fms_api.repository.DashboardSnapshotRepository;
import com.agroconnect.fms_api.service.DashboardSnapshotService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class DashboardSnapshotServiceImpl implements DashboardSnapshotService {

    private final DashboardSnapshotRepository repository;
    private final DashboardSnapshotMapper mapper;

    @Override
    public DashboardSnapshotResponse create(DashboardSnapshotRequest request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }

    @Override
    public DashboardSnapshotResponse getById(Integer id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Snapshot not found"));
    }

    @Override
    public List<DashboardSnapshotResponse> getAll() {
        return repository.findAll().stream().map(mapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public DashboardSnapshotResponse update(Integer id, DashboardSnapshotRequest request) {
        DashboardSnapshot entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Snapshot not found"));

        entity.setFarmId(request.getFarmId());
        entity.setSnapshotDate(request.getSnapshotDate());
        entity.setJsonData(request.getJsonData());

        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}