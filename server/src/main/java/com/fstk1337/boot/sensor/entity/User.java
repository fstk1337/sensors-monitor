package com.fstk1337.boot.sensor.entity;

import com.fstk1337.boot.sensor.model.UserRole;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String password;
    private UserRole role;
}
