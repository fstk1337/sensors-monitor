package com.fstk1337.boot.sensor.service;

import com.fstk1337.boot.sensor.model.Sensor;
import com.fstk1337.boot.sensor.model.SensorType;

import java.util.List;

public interface SensorService {
    Sensor save(Sensor sensor);
    boolean sensorExists(String name);
    boolean sensorExists(Long id);
    List<Sensor> getAllSensors();
    List<SensorType> getAllSensorTypes();
    Sensor getSensorById(Long id);
    Sensor getSensorByName(String name);
    SensorType getSensorTypeByName(String name);
    Sensor update(Sensor sensor);
    void delete(Long id);
    void deleteAllSensors();
}