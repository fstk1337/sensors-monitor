package com.fstk1337.boot.sensor.controller;

import com.fstk1337.boot.sensor.dto.SensorDto;
import com.fstk1337.boot.sensor.model.Sensor;
import com.fstk1337.boot.sensor.model.SensorType;
import com.fstk1337.boot.sensor.service.SensorService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/sensors")
@AllArgsConstructor
public class SensorController {
    private final SensorService sensorService;
    private final ModelMapper mapper;

    @GetMapping
    public List<SensorDto> getAllSensors() {
        return sensorService.getAllSensors().stream()
                .map(sensor -> mapper.map(sensor, SensorDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SensorDto> getSensorById(@PathVariable Long id) {
        if (sensorService.sensorExists(id)) {
            Sensor fetchedSensor = sensorService.getSensorById(id);
            SensorDto sensorResponse = mapper.map(fetchedSensor, SensorDto.class);
            return ResponseEntity.ok(sensorResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> createSensor(@RequestBody SensorDto sensorDto) {
        Sensor sensorRequest = mapper.map(sensorDto, Sensor.class);
        if (!sensorService.sensorExists(sensorRequest.getName())) {
            SensorType sensorType = sensorService.getSensorTypeByName(sensorDto.getType());
            sensorRequest.setSensorType(sensorType);
            Sensor newSensor = sensorService.save(sensorRequest);
            SensorDto sensorResponse = mapper.map(newSensor, SensorDto.class);
            return new ResponseEntity<>(sensorResponse, HttpStatus.CREATED);
        }
        return ResponseEntity.unprocessableEntity().body(Map.of(
                "message",
                String.format("Sensor with name %s already exists", sensorRequest.getName())));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSensor(@PathVariable Long id, @RequestBody SensorDto sensorDto) {
        if (!sensorService.sensorExists(id)) {
            return ResponseEntity.unprocessableEntity().body(Map.of(
                    "message",
                    String.format("Sensor with id = %d not found", id)));
        }
        Sensor sensorRequest = mapper.map(sensorDto, Sensor.class);
        if (sensorService.sensorExists(sensorRequest.getName()) && !Objects.equals(sensorService.getSensorByName(sensorRequest.getName()).getId(), id)) {
            return ResponseEntity.unprocessableEntity().body(Map.of(
                    "message",
                    String.format("Sensor with name %s already exists", sensorRequest.getName())));
        }
        SensorType sensorType = sensorService.getSensorTypeByName(sensorDto.getType());
        sensorRequest.setId(id);
        sensorRequest.setSensorType(sensorType);
        sensorService.update(sensorRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSensorById(@PathVariable Long id) {
        if (!sensorService.sensorExists(id)) {
            return ResponseEntity.unprocessableEntity().body(Map.of(
                    "message",
                    String.format("Sensor with id = %d not found", id)));
        }
        sensorService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
