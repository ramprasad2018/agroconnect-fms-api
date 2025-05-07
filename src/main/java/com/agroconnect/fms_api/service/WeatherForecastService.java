package com.agroconnect.fms_api.service;

import com.agroconnect.fms_api.dto.WeatherForecastRequest;
import com.agroconnect.fms_api.dto.WeatherForecastResponse;
import java.util.List;

public interface WeatherForecastService {
    WeatherForecastResponse create(WeatherForecastRequest request);
    WeatherForecastResponse getById(Integer id);
    List<WeatherForecastResponse> getAll();
    WeatherForecastResponse update(Integer id, WeatherForecastRequest request);
    void delete(Integer id);
}