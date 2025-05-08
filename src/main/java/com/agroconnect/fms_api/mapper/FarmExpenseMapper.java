package com.agroconnect.fms_api.mapper;

import com.agroconnect.fms_api.dto.FarmExpenseRequest;
import com.agroconnect.fms_api.dto.FarmExpenseResponse;
import com.agroconnect.fms_api.model.FarmExpense;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FarmExpenseMapper {
    FarmExpense toEntity(FarmExpenseRequest request);
    FarmExpenseResponse toResponse(FarmExpense entity);
}