package com.dts.miniproject.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dts.miniproject.model.dto.request.LoginRequest;
import com.dts.miniproject.model.dto.response.JwTTokenResponse;
import com.dts.miniproject.model.dto.response.LoginResponse;
import com.dts.miniproject.service.LoginService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class LoginController {
    private LoginService loginService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        return loginService.login(loginRequest);
    }

    @PostMapping("/login/jwt")
    public JwTTokenResponse loginWithJWT(@RequestBody LoginRequest loginRequest) {
        return loginService.loginJWT(loginRequest);
    }
}
