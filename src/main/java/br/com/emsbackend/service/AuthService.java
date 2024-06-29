package br.com.emsbackend.service;

import br.com.emsbackend.dto.LoginDTO;
import br.com.emsbackend.dto.RegisterDTO;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthService {

    String register(RegisterDTO registerDTO);

    String login(LoginDTO loginDTO);
}
