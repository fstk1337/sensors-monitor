package com.fstk1337.boot.sensor.service.sensor;

import com.fstk1337.boot.sensor.model.sensor.Model;
import com.fstk1337.boot.sensor.model.sensor.Sensor;

import java.util.List;

public interface SensorService {
    Sensor save(Sensor sensor);
    Model save(Model model);

    List<Sensor> getAllSensors();
    List<Model> getAllModels();

    Sensor getSensor(Long id);
    Model getModel(Long id);
    Sensor update(Sensor sensor);
    Model update(Model model);
    void delete(Sensor sensor);
    void delete(Model model);

    void deleteAllSensors();
    void deleteAllModels();
}