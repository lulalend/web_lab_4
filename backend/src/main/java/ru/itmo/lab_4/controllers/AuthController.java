package ru.itmo.lab_4.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itmo.lab_4.services.TokenService;

@RestController
public class AuthController {

    private final TokenService tokenService;

    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/token")
    public String token(Authentication authentication) {

        String token = tokenService.generateToken(authentication);

        return token;
    }
}
