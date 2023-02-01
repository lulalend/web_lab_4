package ru.itmo.lab_4.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserDTO {

    @NotNull
    private String username;

    @NotNull
    private String password;
}
