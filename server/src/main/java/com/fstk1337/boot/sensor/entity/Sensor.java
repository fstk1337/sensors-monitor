package com.fstk1337.boot.sensor.entity;

import com.fstk1337.boot.sensor.model.SensorLocation;
import com.fstk1337.boot.sensor.model.SensorType;
import com.fstk1337.boot.sensor.model.SensorUnit;
import lombok.*;
import org.hibernate.Hibernate;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sensor", schema = "public")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String model;
    @Enumerated(EnumType.STRING)
    private SensorType type;
    private int minValue;
    private int maxValue;
    @Enumerated(EnumType.STRING)
    private SensorUnit unit;
    @Enumerated(EnumType.STRING)
    private SensorLocation location;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Sensor sensor = (Sensor) o;
        return getId() != null && Objects.equals(getId(), sensor.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
