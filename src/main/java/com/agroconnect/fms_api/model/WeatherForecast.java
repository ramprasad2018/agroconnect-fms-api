package com.agroconnect.fms_api.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "weather_forecast", schema = "fms")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherForecast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "farm_id")
    private Integer farmId;

    @Column(name = "forecast_date")
    private LocalDate forecastDate;

    private Double temperature;
    private Double humidity;

    @Column(name = "rain_probability")
    private Double rainProbability;

    @Column(name = "wind_speed")
    private Double windSpeed;

    @Column(name = "rainfall_amount")
    private Double rainfallAmount;
}