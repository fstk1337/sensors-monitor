package com.fstk1337.boot.sensor.service.sensor;

import com.fstk1337.boot.sensor.model.sensor.Location;
import com.fstk1337.boot.sensor.model.sensor.Model;
import com.fstk1337.boot.sensor.model.sensor.Sensor;

import java.util.List;

public interface SensorService {
    Sensor save(Sensor sensor);
    Location save(Location location);
    Model save(Model model);

    List<Sensor> getAllSensors();
    List<Location> getAllLocations();
    List<Model> getAllModels();

    Sensor getSensor(String sensorName);
    Location getLocation(String locationName);
    Model getModel(String modelName);
    Sensor update(Sensor sensor);
    Location update(Location location);
    Model update(Model model);
    void delete(Sensor sensor);
    void delete(Location location);
    void delete(Model model);

    void deleteAllSensors();
    void deleteAllLocations();
    void deleteAllModels();
}