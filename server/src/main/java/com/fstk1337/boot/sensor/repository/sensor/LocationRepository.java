package com.fstk1337.boot.sensor.repository.sensor;

import com.fstk1337.boot.sensor.model.sensor.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
    Location findByLocationName(String locationName);
}
