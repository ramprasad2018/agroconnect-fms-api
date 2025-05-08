package com.agroconnect.fms_api.mapper;

import com.agroconnect.fms_api.dto.FarmActivityLogRequest;
import com.agroconnect.fms_api.dto.FarmActivityLogResponse;
import com.agroconnect.fms_api.model.FarmActivityLog;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FarmActivityLogMapper {
    FarmActivityLog toEntity(FarmActivityLogRequest request);
    FarmActivityLogResponse toResponse(FarmActivityLog entity);
}