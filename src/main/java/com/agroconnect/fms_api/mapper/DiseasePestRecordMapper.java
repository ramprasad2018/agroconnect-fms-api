package com.agroconnect.fms_api.mapper;

import com.agroconnect.fms_api.dto.DiseasePestRecordRequest;
import com.agroconnect.fms_api.dto.DiseasePestRecordResponse;
import com.agroconnect.fms_api.model.DiseasePestRecord;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiseasePestRecordMapper {
    DiseasePestRecord toEntity(DiseasePestRecordRequest request);
    DiseasePestRecordResponse toResponse(DiseasePestRecord entity);
}