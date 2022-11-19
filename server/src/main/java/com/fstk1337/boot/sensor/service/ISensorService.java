package com.fstk1337.boot.sensor.service;

import com.fstk1337.boot.sensor.entity.Sensor;

import java.util.List;

public interface ISensorService {
    Sensor create(Sensor sensor);
    List<Sensor> getAll();
    Sensor get(Long id);
    Sensor update(Sensor sensor);
    void delete(Sensor sensor);
    void deleteAll();
}
