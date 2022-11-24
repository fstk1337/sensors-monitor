package com.fstk1337.boot.sensor.repository;

import com.fstk1337.boot.sensor.model.SensorType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorTypeRepository extends JpaRepository<SensorType, Long> {
    SensorType findByName(String name);
}
