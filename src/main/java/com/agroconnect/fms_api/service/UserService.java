package com.agroconnect.fms_api.service;

import com.agroconnect.fms_api.dto.LoginRequest;
import com.agroconnect.fms_api.dto.LoginResponse;

public interface UserService {
    LoginResponse login(LoginRequest request);
}

