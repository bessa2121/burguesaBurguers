package com.br.burguesaBurguers.service;

import com.br.burguesaBurguers.dto.ItemOrderDTO;
import com.br.burguesaBurguers.dto.UserCreateDTO;
import com.br.burguesaBurguers.dto.UserResponseDTO;
import com.br.burguesaBurguers.model.Product;
import com.br.burguesaBurguers.model.User;
import com.br.burguesaBurguers.repository.UserRepository;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponseDTO create(UserCreateDTO dto) {

        User user = new User(
                null,
                dto.getUserName(),
                dto.getUserEmail(),
                passwordEncoder.encode(dto.getPassword())
        );

        User savedUser = userRepository.save(user);

        return new UserResponseDTO(
                savedUser.getId(),
                savedUser.getUserName(),
                savedUser.getUserEmail()
        );
    }

    public List<UserResponseDTO> listAll(){
        return userRepository
                .findAll()
                .stream()
                .map(user -> new UserResponseDTO(
                        user.getId(),
                        user.getUserName(),
                        user.getUserEmail()
                ))
                .toList();
    }
}

