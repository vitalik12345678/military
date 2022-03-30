package com.example.military.service.impl;

import com.example.military.DTO.user.UserCreateRequest;
import com.example.military.DTO.user.UserProfileResponse;
import com.example.military.exception.ExistsException;
import com.example.military.exception.NotExistsException;
import com.example.military.model.User;
import com.example.military.repository.UserRepository;
import com.example.military.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public ResponseEntity<UserProfileResponse> findUserByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> {
            throw new NotExistsException("User didn't find");
        });
        UserProfileResponse responseUser = new UserProfileResponse();
        BeanUtils.copyProperties(user, responseUser);
        return ResponseEntity.ok(responseUser);
    }

    @Override
    public ResponseEntity<UserProfileResponse> createUser(UserCreateRequest userCreateRequest) {
        if (userRepository.findByEmail(userCreateRequest.getEmail()).isPresent()) {
            throw new ExistsException("User with same phone or email is already exist");
        }
        User user = new User();
        BeanUtils.copyProperties(userCreateRequest, user);
        user.setPassword(bCryptPasswordEncoder.encode(userCreateRequest.getPassword()));
        
        return ResponseEntity.ok(new UserProfileResponse());
    }
}
