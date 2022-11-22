package com.fstk1337.boot.sensor.model.sensor;

import lombok.*;
import org.hibernate.Hibernate;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sensors")
@SequenceGenerator(
    name = "sensorIdGenerator",
    sequenceName = "sensor_id_sequence",
    initialValue = 1000,
    allocationSize = 1
)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sensorIdGenerator")
    private Long id;
    @Column(unique = true)
    private String name;
    private String model;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sensor_type_id")
    private SensorType sensorType;
    private int minValue;
    private int maxValue;
    @Basic
    private String location;
    @Basic
    private String description;

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
