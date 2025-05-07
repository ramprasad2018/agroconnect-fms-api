package com.agroconnect.fms_api.mapper;

import com.agroconnect.fms_api.dto.WeatherForecastRequest;
import com.agroconnect.fms_api.dto.WeatherForecastResponse;
import com.agroconnect.fms_api.model.WeatherForecast;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WeatherForecastMapper {
    WeatherForecast toEntity(WeatherForecastRequest request);
    WeatherForecastResponse toResponse(WeatherForecast entity);
}