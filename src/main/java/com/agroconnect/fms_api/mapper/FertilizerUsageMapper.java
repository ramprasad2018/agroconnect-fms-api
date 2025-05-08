package com.agroconnect.fms_api.mapper;

import com.agroconnect.fms_api.dto.FertilizerUsageRequest;
import com.agroconnect.fms_api.dto.FertilizerUsageResponse;
import com.agroconnect.fms_api.model.FertilizerUsage;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FertilizerUsageMapper {
    FertilizerUsage toEntity(FertilizerUsageRequest request);
    FertilizerUsageResponse toResponse(FertilizerUsage entity);
}