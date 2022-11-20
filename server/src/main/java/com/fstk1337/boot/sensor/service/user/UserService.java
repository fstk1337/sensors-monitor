package com.fstk1337.boot.sensor.service.user;

import com.fstk1337.boot.sensor.model.user.Role;
import com.fstk1337.boot.sensor.model.user.User;

import java.util.List;

public interface UserService {
    User save(User user);
    Role save(Role role);
    List<User> getAllUsers();
    List<Role> getAllRoles();
    User getUser(String username);
    Role getRole(String roleName);
    User update(User user);
    Role update(Role role);
    User applyRoleToUser(String  username, String roleName);
    void delete(User user);
    void delete(Role role);

    void deleteAllUsers();
    void deleteAllRoles();
}
