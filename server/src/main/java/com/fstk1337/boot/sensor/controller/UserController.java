package com.fstk1337.boot.sensor.controller;

import com.fstk1337.boot.sensor.dto.UserDto;
import com.fstk1337.boot.sensor.model.user.User;
import com.fstk1337.boot.sensor.service.user.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper mapper;

    @Autowired
    public UserController(UserService userService, ModelMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers().stream()
                .map(user -> mapper.map(user, UserDto.class))
                .collect(Collectors.toList());
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