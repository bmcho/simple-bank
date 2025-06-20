package com.bmcho.simplebank.controller;

import com.bmcho.simplebank.model.Customer;
import com.bmcho.simplebank.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
            userService.registerUser(customer);
            return ResponseEntity.status(HttpStatus.OK).build();
    }

}
