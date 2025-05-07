package com.agroconnect.fms_api.service.impl;

import com.agroconnect.fms_api.dto.IrrigationScheduleRequest;
import com.agroconnect.fms_api.dto.IrrigationScheduleResponse;
import com.agroconnect.fms_api.model.IrrigationSchedule;
import com.agroconnect.fms_api.repository.IrrigationScheduleRepository;
import com.agroconnect.fms_api.service.IrrigationScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IrrigationScheduleServiceImpl implements IrrigationScheduleService {

    private final IrrigationScheduleRepository repository;

    @Override
    public IrrigationScheduleResponse create(IrrigationScheduleRequest request) {
        IrrigationSchedule schedule = mapToEntity(request);
        return mapToResponse(repository.save(schedule));
    }

    @Override
    public IrrigationScheduleResponse getById(Integer id) {
        IrrigationSchedule schedule = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Schedule not found"));
        return mapToResponse(schedule);
    }

    @Override
    public List<IrrigationScheduleResponse> getAll() {
        return repository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public IrrigationScheduleResponse update(Integer id, IrrigationScheduleRequest request) {
        IrrigationSchedule schedule = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Schedule not found"));

        schedule.setFarmId(request.getFarmId());
        schedule.setScheduledDate(request.getScheduledDate());
        schedule.setMethod(request.getMethod());
        schedule.setWaterQuantity(request.getWaterQuantity());
        schedule.setStatus(request.getStatus());
        schedule.setNotes(request.getNotes());

        return mapToResponse(repository.save(schedule));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    private IrrigationSchedule mapToEntity(IrrigationScheduleRequest request) {
        IrrigationSchedule schedule = new IrrigationSchedule();
        schedule.setFarmId(request.getFarmId());
        schedule.setScheduledDate(request.getScheduledDate());
        schedule.setMethod(request.getMethod());
        schedule.setWaterQuantity(request.getWaterQuantity());
        schedule.setStatus(request.getStatus());
        schedule.setNotes(request.getNotes());
        return schedule;
    }

    private IrrigationScheduleResponse mapToResponse(IrrigationSchedule schedule) {
        return IrrigationScheduleResponse.builder()
            .id(schedule.getId())
            .farmId(schedule.getFarmId())
            .scheduledDate(schedule.getScheduledDate())
            .method(schedule.getMethod())
            .waterQuantity(schedule.getWaterQuantity())
            .status(schedule.getStatus())
            .notes(schedule.getNotes())
            .createdAt(schedule.getCreatedAt())
            .build();
    }
}
