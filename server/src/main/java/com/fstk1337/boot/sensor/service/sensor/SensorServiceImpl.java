package com.fstk1337.boot.sensor.service.sensor;

import com.fstk1337.boot.sensor.model.sensor.Model;
import com.fstk1337.boot.sensor.model.sensor.Sensor;
import com.fstk1337.boot.sensor.repository.sensor.ModelRepository;
import com.fstk1337.boot.sensor.repository.sensor.SensorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class SensorServiceImpl implements SensorService {
    private final SensorRepository sensorRepository;
    private final ModelRepository modelRepository;

    @Autowired
    public SensorServiceImpl(SensorRepository sensorRepository, ModelRepository modelRepository) {
        this.sensorRepository = sensorRepository;
        this.modelRepository = modelRepository;
    }

    @Override
    public Sensor save(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    @Override
    public Model save(Model model) {
        return modelRepository.save(model);
    }

    @Override
    public List<Sensor> getAllSensors() {
        return sensorRepository.findAll();
    }

    @Override
    public List<Model> getAllModels() {
        return modelRepository.findAll();
    }

    @Override
    public Sensor getSensor(Long id) {
        return sensorRepository.findById(id).orElse(null);
    }

    @Override
    public Model getModel(Long id) {
        return modelRepository.findById(id).orElse(null);
    }

    @Override
    public Sensor update(Sensor sensor) {
        if (sensorRepository.existsById(sensor.getId())) {
            return sensorRepository.save(sensor);
        }
        return null;
    }

    @Override
    public Model update(Model model) {
        if (modelRepository.existsById(model.getId())) {
            return modelRepository.save(model);
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
    public void delete(Model model) {
        if (modelRepository.exists(Example.of(model))) {
            modelRepository.delete(model);
        }
    }

    @Override
    public void deleteAllSensors() {
        sensorRepository.deleteAll();
    }

    @Override
    public void deleteAllModels() {
        modelRepository.deleteAll();
    }
}
