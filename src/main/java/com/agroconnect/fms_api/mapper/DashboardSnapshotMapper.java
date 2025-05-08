package com.agroconnect.fms_api.mapper;

import com.agroconnect.fms_api.dto.DashboardSnapshotRequest;
import com.agroconnect.fms_api.dto.DashboardSnapshotResponse;
import com.agroconnect.fms_api.model.DashboardSnapshot;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DashboardSnapshotMapper {
    DashboardSnapshot toEntity(DashboardSnapshotRequest request);
    DashboardSnapshotResponse toResponse(DashboardSnapshot entity);
}