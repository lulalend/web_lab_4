package ru.itmo.lab_4.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import ru.itmo.lab_4.dto.UserDTO;
import ru.itmo.lab_4.exception.UserAlreadyExistsException;

@Service
public class RegisterService {
    private final static String USER_ROLE = "user";
    private final UserDetailsManager manager;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegisterService(UserDetailsManager manager,
                           PasswordEncoder passwordEncoder) {
        this.manager = manager;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(UserDTO user) {
        if ( manager.userExists(user.getUsername()) ) {
            throw new UserAlreadyExistsException("Пользователь с таким " +
                    " именем уже существует(");
        }
        manager.createUser(
                User.builder()
                        .username(user.getUsername())
                        .password(passwordEncoder.encode(user.getPassword()))
                        .roles(USER_ROLE)
                        .build());
    }

}
