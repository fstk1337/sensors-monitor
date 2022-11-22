package com.fstk1337.boot.sensor.controller;

import com.fstk1337.boot.sensor.dto.SensorDto;
import com.fstk1337.boot.sensor.model.sensor.Sensor;
import com.fstk1337.boot.sensor.model.sensor.SensorType;
import com.fstk1337.boot.sensor.service.sensor.SensorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/sensors")
public class SensorController {
    private final SensorService sensorService;
    private final ModelMapper mapper;

    @Autowired
    public SensorController(ModelMapper mapper, SensorService sensorService) {
        this.sensorService = sensorService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<SensorDto> getAllSensors() {
        return sensorService.getAllSensors().stream()
                .map(sensor -> mapper.map(sensor, SensorDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SensorDto> getSensorById(@PathVariable Long id) {
        Sensor fetchedSensor = sensorService.getSensor(id);
        if (fetchedSensor != null) {
            SensorDto sensorResponse = mapper.map(fetchedSensor, SensorDto.class);
            return ResponseEntity.ok(sensorResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<SensorDto> createSensor(@RequestBody SensorDto sensorDto) {
        Sensor sensorRequest = mapper.map(sensorDto, Sensor.class);
        SensorType sensorType = sensorService.getSensorTypeByName(sensorDto.getType());
        sensorRequest.setSensorType(sensorType);
        Sensor newSensor = sensorService.save(sensorRequest);
        SensorDto sensorResponse = mapper.map(newSensor, SensorDto.class);
        return new ResponseEntity<>(sensorResponse, HttpStatus.CREATED);
    }
}
