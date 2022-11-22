package com.fstk1337.boot.sensor.repository.sensor;

import com.fstk1337.boot.sensor.model.sensor.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {
    Sensor findByName(String name);
    boolean existsByName(String name);
}
