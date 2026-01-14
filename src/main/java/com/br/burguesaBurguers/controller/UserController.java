package com.br.burguesaBurguers.controller;

import com.br.burguesaBurguers.dto.UserCreateDTO;
import com.br.burguesaBurguers.dto.UserResponseDTO;
import com.br.burguesaBurguers.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserCreateDTO dto) {
        UserResponseDTO user = userService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
