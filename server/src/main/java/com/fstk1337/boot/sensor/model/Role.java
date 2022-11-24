package com.fstk1337.boot.sensor.model;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.data.annotation.Immutable;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Immutable
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Role {
    @Id
    private Long id;
    @Column(name = "role_name", unique = true)
    private String roleName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Role role = (Role) o;
        return id != null && Objects.equals(id, role.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
