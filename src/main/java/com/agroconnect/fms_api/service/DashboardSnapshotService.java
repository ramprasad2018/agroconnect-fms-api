package com.agroconnect.fms_api.service;

import com.agroconnect.fms_api.dto.DashboardSnapshotRequest;
import com.agroconnect.fms_api.dto.DashboardSnapshotResponse;

import java.util.List;

public interface DashboardSnapshotService {
    DashboardSnapshotResponse create(DashboardSnapshotRequest request);
    DashboardSnapshotResponse getById(Integer id);
    List<DashboardSnapshotResponse> getAll();
    DashboardSnapshotResponse update(Integer id, DashboardSnapshotRequest request);
    void delete(Integer id);
}