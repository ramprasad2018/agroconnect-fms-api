package com.agroconnect.fms_api.controller;

import com.agroconnect.fms_api.dto.LoginRequest;
import com.agroconnect.fms_api.dto.LoginResponse;
import com.agroconnect.fms_api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }
}
