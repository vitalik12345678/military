package com.example.military.service;

import com.example.military.DTO.user.UserCreateRequest;
import com.example.military.DTO.user.UserProfileResponse;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<UserProfileResponse> findUserByEmail(String email);

    ResponseEntity<UserProfileResponse> createUser(UserCreateRequest userCreateRequest);
}
