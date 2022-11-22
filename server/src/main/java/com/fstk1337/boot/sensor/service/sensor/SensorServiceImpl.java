package com.fstk1337.boot.sensor.service.sensor;

import com.fstk1337.boot.sensor.model.sensor.Sensor;
import com.fstk1337.boot.sensor.model.sensor.SensorType;
import com.fstk1337.boot.sensor.repository.sensor.SensorRepository;
import com.fstk1337.boot.sensor.repository.sensor.SensorTypeRepository;
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
    public Sensor getSensor(Long id) {
        return sensorRepository.findById(id).orElse(null);
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
