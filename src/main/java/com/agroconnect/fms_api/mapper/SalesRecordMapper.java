package com.agroconnect.fms_api.mapper;

import com.agroconnect.fms_api.dto.SalesRecordRequest;
import com.agroconnect.fms_api.dto.SalesRecordResponse;
import com.agroconnect.fms_api.model.SalesRecord;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SalesRecordMapper {
    SalesRecord toEntity(SalesRecordRequest request);
    SalesRecordResponse toResponse(SalesRecord entity);
}