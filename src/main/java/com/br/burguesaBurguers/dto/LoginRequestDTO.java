package com.br.burguesaBurguers.dto;

import com.br.burguesaBurguers.model.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequestDTO {

    private String userEmail;
    private String password;
}
