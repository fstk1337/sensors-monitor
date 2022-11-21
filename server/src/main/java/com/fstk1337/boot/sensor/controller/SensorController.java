package com.fstk1337.boot.sensor.controller;

import com.fstk1337.boot.sensor.dto.SensorDto;
import com.fstk1337.boot.sensor.mapper.Mapper;
import com.fstk1337.boot.sensor.model.sensor.Sensor;
import com.fstk1337.boot.sensor.service.sensor.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sensors")
public class SensorController {
    private final SensorService sensorService;
    private final Mapper mapper;

    @Autowired
    public SensorController(Mapper mapper, SensorService sensorService) {
        this.sensorService = sensorService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<SensorDto> getAllSensors() {
        return mapper.mapList(sensorService.getAllSensors(), SensorDto.class);
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
}
