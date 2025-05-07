package com.agroconnect.fms_api.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherForecastResponse {
    private Integer id;
    private Integer farmId;
    private LocalDate forecastDate;
    private Double temperature;
    private Double humidity;
    private Double rainProbability;
    private Double windSpeed;
    private Double rainfallAmount;
}