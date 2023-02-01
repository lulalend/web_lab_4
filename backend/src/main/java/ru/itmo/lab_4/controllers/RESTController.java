package ru.itmo.lab_4.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.itmo.lab_4.dto.DotRequestDTO;
import ru.itmo.lab_4.dto.DotResponseDTO;
import ru.itmo.lab_4.dto.UserDTO;
import ru.itmo.lab_4.entities.Dot;
import ru.itmo.lab_4.entities.User;
import ru.itmo.lab_4.services.DotService;

import java.security.Principal;
import java.util.List;


@RestController
public class RESTController {

    private final DotService dotService;
    private final ModelMapper mapper;

    @Autowired
    public RESTController(DotService dotService,
                          ModelMapper mapper) {
        this.dotService = dotService;
        this.mapper = mapper;
    }

    @PostMapping("/dots")
    public DotResponseDTO addNewDot(Principal user, @RequestBody DotRequestDTO dotRequestDTO) {
        Dot dot = this.mapper.map(dotRequestDTO, Dot.class);
        dot = this.dotService.enrichDot(dot, user.getName());

        this.dotService.saveDot(dot);

        return this.mapper.map(dot, DotResponseDTO.class);
    }

    @DeleteMapping("/dots")
    public String deleteDotsByUsername(Principal user) {
        this.dotService.deleteAllDotsByUsername(user.getName());
        return "Успешно удалено!";
    }

    @GetMapping("/dots")
    public List<Dot> getAllDots(Principal user) {
        System.out.println("1234567890");
        System.out.println(user.getName());
        return this.dotService.getAllDotsByUsername(user.getName());
    }

}
