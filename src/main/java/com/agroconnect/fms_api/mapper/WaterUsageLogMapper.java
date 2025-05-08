package com.agroconnect.fms_api.mapper;

import com.agroconnect.fms_api.dto.WaterUsageLogRequest;
import com.agroconnect.fms_api.dto.WaterUsageLogResponse;
import com.agroconnect.fms_api.model.WaterUsageLog;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WaterUsageLogMapper {
    WaterUsageLog toEntity(WaterUsageLogRequest request);
    WaterUsageLogResponse toResponse(WaterUsageLog entity);
}