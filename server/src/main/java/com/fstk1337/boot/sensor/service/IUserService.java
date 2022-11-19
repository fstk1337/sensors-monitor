package com.fstk1337.boot.sensor.service;

import com.fstk1337.boot.sensor.entity.User;

import java.util.List;

public interface IUserService {
    User create(User user);
    List<User> getAll();
    User get(Long id);
    User update(User user);
    void delete(User user);
    void deleteAll();
}
