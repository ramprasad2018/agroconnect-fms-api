package com.agroconnect.fms_api.mapper;

import com.agroconnect.fms_api.dto.HarvestRecordRequest;
import com.agroconnect.fms_api.dto.HarvestRecordResponse;
import com.agroconnect.fms_api.model.HarvestRecord;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HarvestRecordMapper {
    HarvestRecord toEntity(HarvestRecordRequest request);
    HarvestRecordResponse toResponse(HarvestRecord entity);
}