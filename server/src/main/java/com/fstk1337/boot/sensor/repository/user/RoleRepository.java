package com.fstk1337.boot.sensor.repository.user;

import com.fstk1337.boot.sensor.model.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(String roleName);
}
