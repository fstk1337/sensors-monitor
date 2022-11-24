package com.fstk1337.boot.sensor.controller;

import com.fstk1337.boot.sensor.dto.AuthRequestDto;
import com.fstk1337.boot.sensor.dto.AuthResponseDto;
import com.fstk1337.boot.sensor.model.User;
import com.fstk1337.boot.sensor.security.JwtUtil;
import com.fstk1337.boot.sensor.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthenticationManager authManager;
    private final UserService userDetailsService;
    private final JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<?> authorize(@RequestBody AuthRequestDto authRequestDto) throws Exception {
        try {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDto.getUsername(), authRequestDto.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        User userDetails = userDetailsService.loadUserByUsername(authRequestDto.getUsername());
        String token = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthResponseDto(token));
    }
}
