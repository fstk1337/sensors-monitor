package com.fstk1337.boot.sensor.service.sensor;

import com.fstk1337.boot.sensor.model.sensor.Sensor;
import com.fstk1337.boot.sensor.model.sensor.SensorType;

import java.util.List;

public interface SensorService {
    Sensor save(Sensor sensor);
    List<Sensor> getAllSensors();
    List<SensorType> getAllSensorTypes();
    Sensor getSensor(Long id);
    SensorType getSensorType(Long id);
    Sensor update(Sensor sensor);
    void delete(Sensor sensor);
    void deleteAllSensors();
}