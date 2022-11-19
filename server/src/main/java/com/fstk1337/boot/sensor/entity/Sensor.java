package com.fstk1337.boot.sensor.entity;

import com.fstk1337.boot.sensor.model.SensorLocation;
import com.fstk1337.boot.sensor.model.SensorType;
import com.fstk1337.boot.sensor.model.SensorUnit;

import lombok.*;
import org.hibernate.Hibernate;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private String model;
    private SensorType type;
    private int minValue;
    private int maxValue;
    private SensorUnit unit;
    private SensorLocation location;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Sensor sensor = (Sensor) o;
        return id != null && Objects.equals(id, sensor.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
