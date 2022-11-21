package com.fstk1337.boot.sensor.model.sensor;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "sensor_types")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SensorType {
    @Id
    private Long id;
    @ReadOnlyProperty
    private String type;
    @ReadOnlyProperty
    private String unit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SensorType sensorType = (SensorType) o;
        return id != null && Objects.equals(id, sensorType.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
