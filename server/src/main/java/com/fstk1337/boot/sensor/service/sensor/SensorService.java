package com.fstk1337.boot.sensor.service.sensor;

import com.fstk1337.boot.sensor.model.sensor.Sensor;
import com.fstk1337.boot.sensor.model.sensor.SensorType;

import java.util.List;

public interface SensorService {
    Sensor save(Sensor sensor);
    List<Sensor> getAllSensors();
    List<SensorType> getAllSensorTypes();
    Sensor getSensor(Long id);
    SensorType getSensorTypeByName(String name);
    Sensor update(Sensor sensor);
    void delete(Long id);
    void deleteAllSensors();
}