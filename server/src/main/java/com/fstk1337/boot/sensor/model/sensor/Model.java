package com.fstk1337.boot.sensor.model.sensor;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "models")
@SequenceGenerator(
    name = "modelIdGenerator",
    sequenceName = "model_id_sequence",
    initialValue = 500,
    allocationSize = 1
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modelIdGenerator")
    private Long id;
    @Column(name = "model_name", unique = true)
    private String modelName;
    @Enumerated(EnumType.STRING)
    private SensorType type;
    @Column(name = "min_value")
    private int minValue;
    @Column(name = "max_value")
    private int maxValue;

    public String getUnit() {
        return type.getUnit();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Model model = (Model) o;
        return id != null && Objects.equals(id, model.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    enum SensorType {
        Pressure("bar"),
        Voltage("voltage"),
        Temperature("\u2103"),
        Humidity("%");

        private final String unit;

        SensorType(String unit) {
            this.unit = unit;
        }
        String getUnit() {
            return unit;
        }
    }
}
