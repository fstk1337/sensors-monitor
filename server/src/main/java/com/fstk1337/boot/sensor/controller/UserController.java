package com.fstk1337.boot.sensor.controller;

import com.fstk1337.boot.sensor.dto.UserDto;
import com.fstk1337.boot.sensor.mapper.Mapper;
import com.fstk1337.boot.sensor.model.user.User;
import com.fstk1337.boot.sensor.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final Mapper mapper;
    private final UserService userService;

    @Autowired
    public UserController(UserService userService, Mapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return mapper.mapList(userService.getAllUsers(), UserDto.class);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        User fetchedUser = userService.getUser(id);
        if (fetchedUser != null) {
            UserDto userResponse = mapper.map(fetchedUser, UserDto.class);
            return ResponseEntity.ok(userResponse);
        }
        return ResponseEntity.notFound().build();
    }
}