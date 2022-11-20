package com.fstk1337.boot.sensor.repository.sensor;

import com.fstk1337.boot.sensor.model.sensor.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {
    Model findByModelName(String modelName);
}
