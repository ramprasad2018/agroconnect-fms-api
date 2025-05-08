package com.agroconnect.fms_api.mapper;

import com.agroconnect.fms_api.dto.LabourRecordRequest;
import com.agroconnect.fms_api.dto.LabourRecordResponse;
import com.agroconnect.fms_api.model.LabourRecord;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LabourRecordMapper {
    LabourRecord toEntity(LabourRecordRequest request);
    LabourRecordResponse toResponse(LabourRecord entity);
}