package com.agroconnect.fms_api.service.impl;

import com.agroconnect.fms_api.dto.LoginRequest;
import com.agroconnect.fms_api.dto.LoginResponse;
import com.agroconnect.fms_api.model.User;
import com.agroconnect.fms_api.repository.UserRepository;
import com.agroconnect.fms_api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public LoginResponse login(LoginRequest request) {
        Optional<User> userOpt = userRepository.findByUsername(request.getUsername());

        if (userOpt.isEmpty()) {
            return LoginResponse.builder()
                .message("Invalid username")
                .username(null)
                .role(null)
                .build();
        }

        User user = userOpt.get();

        if (!user.getPasswordHash().equals(request.getPassword())) {
            return LoginResponse.builder()
                .message("Invalid password")
                .username(user.getUsername())
                .role(null)
                .build();
        }

        user.setLastLogin(LocalDateTime.now());
        userRepository.save(user);

        return LoginResponse.builder()
            .message("Login successful")
            .username(user.getUsername())
            .role(user.getRole())
            .build();
    }
}
