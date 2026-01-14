package com.br.burguesaBurguers.service;

import com.br.burguesaBurguers.dto.LoginRequestDTO;
import com.br.burguesaBurguers.dto.LoginResponseDTO;
import com.br.burguesaBurguers.model.User;
import com.br.burguesaBurguers.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public LoginResponseDTO login(LoginRequestDTO dto){
        User user = userRepository.findByUserEmail(dto.getUserEmail())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if(!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Senha Inválida");
        }
    }
}
