package ru.itmo.lab_4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.lab_4.entities.User;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
}
