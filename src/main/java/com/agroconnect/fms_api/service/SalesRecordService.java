package com.agroconnect.fms_api.service;

import com.agroconnect.fms_api.dto.SalesRecordRequest;
import com.agroconnect.fms_api.dto.SalesRecordResponse;

import java.util.List;

public interface SalesRecordService {
    SalesRecordResponse create(SalesRecordRequest request);
    SalesRecordResponse getById(Integer id);
    List<SalesRecordResponse> getAll();
    SalesRecordResponse update(Integer id, SalesRecordRequest request);
    void delete(Integer id);
}