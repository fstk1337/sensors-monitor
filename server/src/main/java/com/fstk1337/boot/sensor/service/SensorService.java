package com.fstk1337.boot.sensor.service;

import com.fstk1337.boot.sensor.entity.Sensor;
import com.fstk1337.boot.sensor.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorService implements ISensorService {
    private final SensorRepository sensorRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Override
    public Sensor create(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    @Override
    public List<Sensor> getAll() {
        return sensorRepository.findAll();
    }

    @Override
    public Sensor get(Long id) {
        return sensorRepository.findById(id).orElse(null);
    }

    @Override
    public Sensor update(Sensor sensor) {
        if (sensorRepository.existsById(sensor.getId())) {
            return sensorRepository.save(sensor);
        }
        return null;
    }

    @Override
    public void delete(Sensor sensor) {
        if (sensorRepository.exists(Example.of(sensor))) {
            sensorRepository.delete(sensor);
        }
    }

    @Override
    public void deleteAll() {
        sensorRepository.deleteAll();
    }
}
