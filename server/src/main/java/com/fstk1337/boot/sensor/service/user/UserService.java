package com.fstk1337.boot.sensor.service.user;

import com.fstk1337.boot.sensor.model.user.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUser(Long id);
}
