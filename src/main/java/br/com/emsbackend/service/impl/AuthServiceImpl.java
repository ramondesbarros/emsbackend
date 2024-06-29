package br.com.emsbackend.service.impl;

import br.com.emsbackend.dto.LoginDTO;
import br.com.emsbackend.dto.RegisterDTO;
import br.com.emsbackend.exception.ManagementAPIException;
import br.com.emsbackend.repository.RoleRepository;
import br.com.emsbackend.repository.UserRepository;
import br.com.emsbackend.security.Role;
import br.com.emsbackend.security.User;
import br.com.emsbackend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;
import java.util.Collection;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public String register(RegisterDTO registerDTO) {
        // check username is already exists in database
        if(userRepository.existsByUsername(registerDTO.getUsername())){
            throw new ManagementAPIException(HttpStatus.BAD_REQUEST, "Username already exists!");
        }

        // check email is already exists in database
        if(userRepository.existsByEmail(registerDTO.getEmail())){
            throw new ManagementAPIException(HttpStatus.BAD_REQUEST, "Email is already exists!.");
        }

        User user = new User();
        user.setName(registerDTO.getName());
        user.setUsername(registerDTO.getUsername());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName("ROLE_USER");
        roles.add(userRole);

        user.setRoles(roles);

        userRepository.save(user);

        return "User Registered Successfully!.";
    }

    @Override
    public String login(LoginDTO loginDTO) {

        loginDTO.setUsernameOrEmail("ramondesbarros@gmail.com");
        loginDTO.setPassword("123456");

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDTO.getUsernameOrEmail(),
                loginDTO.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "User logged-in successfully!.";
    }
}
