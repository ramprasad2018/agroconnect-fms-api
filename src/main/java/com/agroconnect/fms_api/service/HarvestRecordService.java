package com.agroconnect.fms_api.service;

import com.agroconnect.fms_api.dto.HarvestRecordRequest;
import com.agroconnect.fms_api.dto.HarvestRecordResponse;

import java.util.List;

public interface HarvestRecordService {
    HarvestRecordResponse create(HarvestRecordRequest request);
    HarvestRecordResponse getById(Integer id);
    List<HarvestRecordResponse> getAll();
    HarvestRecordResponse update(Integer id, HarvestRecordRequest request);
    void delete(Integer id);
}