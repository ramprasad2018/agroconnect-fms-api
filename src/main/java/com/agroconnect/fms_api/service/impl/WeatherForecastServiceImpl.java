package com.agroconnect.fms_api.service.impl;

import com.agroconnect.fms_api.dto.WeatherForecastRequest;
import com.agroconnect.fms_api.dto.WeatherForecastResponse;
import com.agroconnect.fms_api.mapper.WeatherForecastMapper;
import com.agroconnect.fms_api.model.WeatherForecast;
import com.agroconnect.fms_api.repository.WeatherForecastRepository;
import com.agroconnect.fms_api.service.WeatherForecastService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class WeatherForecastServiceImpl implements WeatherForecastService {

    private final WeatherForecastRepository repository;
    private final WeatherForecastMapper mapper;

    @Override
    public WeatherForecastResponse create(WeatherForecastRequest request) {
        WeatherForecast entity = mapper.toEntity(request);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public WeatherForecastResponse getById(Integer id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Forecast not found"));
    }

    @Override
    public List<WeatherForecastResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public WeatherForecastResponse update(Integer id, WeatherForecastRequest request) {
        WeatherForecast existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Forecast not found"));

        existing.setFarmId(request.getFarmId());
        existing.setForecastDate(request.getForecastDate());
        existing.setTemperature(request.getTemperature());
        existing.setHumidity(request.getHumidity());
        existing.setRainProbability(request.getRainProbability());
        existing.setWindSpeed(request.getWindSpeed());
        existing.setRainfallAmount(request.getRainfallAmount());

        return mapper.toResponse(repository.save(existing));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}