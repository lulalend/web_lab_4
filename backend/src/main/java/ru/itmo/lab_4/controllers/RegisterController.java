package ru.itmo.lab_4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.itmo.lab_4.dto.UserDTO;
import ru.itmo.lab_4.services.RegisterService;

@RestController
public class RegisterController {

    private final RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/sign_up")
    public void register(@RequestBody UserDTO user) {
        registerService.register(user);
    }

}
