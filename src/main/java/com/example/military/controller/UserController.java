package com.example.military.controller;

import com.example.military.DTO.user.UserCreateRequest;
import com.example.military.DTO.user.UserProfileResponse;
import com.example.military.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/v1")
    public String test(){
        return "Goood";
    }

    @PostMapping(value = "/v1")
    public ResponseEntity<UserProfileResponse> createUser(
            @RequestBody
                    UserCreateRequest userCreateRequest){
        return userService.createUser(userCreateRequest);
    }

    @GetMapping("/v1/{email}")
    public ResponseEntity<UserProfileResponse> getUserById(@PathVariable("email") String email){
        return userService.findUserByEmail(email);
    }
}

