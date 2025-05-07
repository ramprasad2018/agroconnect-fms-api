package com.agroconnect.fms_api.service;

import com.agroconnect.fms_api.dto.DiseasePestRecordRequest;
import com.agroconnect.fms_api.dto.DiseasePestRecordResponse;

import java.util.List;

public interface DiseasePestRecordService {
    DiseasePestRecordResponse create(DiseasePestRecordRequest request);
    DiseasePestRecordResponse getById(Integer id);
    List<DiseasePestRecordResponse> getAll();
    DiseasePestRecordResponse update(Integer id, DiseasePestRecordRequest request);
    void delete(Integer id);
}