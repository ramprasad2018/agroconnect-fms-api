package com.agroconnect.fms_api.mapper;

import com.agroconnect.fms_api.dto.FarmRevenueRequest;
import com.agroconnect.fms_api.dto.FarmRevenueResponse;
import com.agroconnect.fms_api.model.FarmRevenue;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FarmRevenueMapper {
    FarmRevenue toEntity(FarmRevenueRequest request);
    FarmRevenueResponse toResponse(FarmRevenue entity);
}