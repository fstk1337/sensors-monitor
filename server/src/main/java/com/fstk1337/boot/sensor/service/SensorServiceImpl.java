package com.fstk1337.boot.sensor.service;

import com.fstk1337.boot.sensor.model.Sensor;
import com.fstk1337.boot.sensor.model.SensorType;
import com.fstk1337.boot.sensor.repository.SensorRepository;
import com.fstk1337.boot.sensor.repository.SensorTypeRepository;
import com.fstk1337.boot.sensor.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorServiceImpl implements SensorService {
    private final SensorRepository sensorRepository;
    private final SensorTypeRepository sensorTypeRepository;

    @Autowired
    public SensorServiceImpl(SensorRepository sensorRepository, SensorTypeRepository sensorTypeRepository) {
        this.sensorRepository = sensorRepository;
        this.sensorTypeRepository = sensorTypeRepository;
    }

    @Override
    public Sensor save(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    @Override
    public List<Sensor> getAllSensors() {
        return sensorRepository.findAll();
    }

    @Override
    public List<SensorType> getAllSensorTypes() {
        return sensorTypeRepository.findAll();
    }

    @Override
    public Sensor getSensorById(Long id) {
        return sensorRepository.findById(id).orElse(null);
    }

    @Override
    public Sensor getSensorByName(String name) {
        return sensorRepository.findByName(name);
    }

    @Override
    public boolean sensorExists(String name) {
        return sensorRepository.existsByName(name);
    }

    @Override
    public boolean sensorExists(Long id) {
        return sensorRepository.existsById(id);
    }

    @Override
    public SensorType getSensorTypeByName(String name) {
        return sensorTypeRepository.findByName(name);
    }

    @Override
    public Sensor update(Sensor sensor) {
        if (sensorRepository.existsById(sensor.getId())) {
            return sensorRepository.save(sensor);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        if (sensorRepository.existsById(id)) {
            sensorRepository.deleteById(id);
        }
    }

    @Override
    public void deleteAllSensors() {
        sensorRepository.deleteAll();
    }
}
