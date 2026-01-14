package com.br.burguesaBurguers.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class UserResponseDTO {

    private UUID id;
    private String userName;
    private String userEmail;
}
