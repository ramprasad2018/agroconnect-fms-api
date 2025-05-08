package com.agroconnect.fms_api.mapper;

import com.agroconnect.fms_api.dto.PesticideUsageRequest;
import com.agroconnect.fms_api.dto.PesticideUsageResponse;
import com.agroconnect.fms_api.model.PesticideUsage;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PesticideUsageMapper {
    PesticideUsage toEntity(PesticideUsageRequest request);
    PesticideUsageResponse toResponse(PesticideUsage entity);
}