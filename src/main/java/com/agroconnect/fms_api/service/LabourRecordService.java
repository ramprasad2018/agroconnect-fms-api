package com.agroconnect.fms_api.service;

import com.agroconnect.fms_api.dto.LabourRecordRequest;
import com.agroconnect.fms_api.dto.LabourRecordResponse;

import java.util.List;

public interface LabourRecordService {
    LabourRecordResponse create(LabourRecordRequest request);
    LabourRecordResponse getById(Integer id);
    List<LabourRecordResponse> getAll();
    LabourRecordResponse update(Integer id, LabourRecordRequest request);
    void delete(Integer id);
}