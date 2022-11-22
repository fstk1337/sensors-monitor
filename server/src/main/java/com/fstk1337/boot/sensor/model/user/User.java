package com.fstk1337.boot.sensor.model.user;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.data.annotation.Immutable;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Immutable
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Id
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
