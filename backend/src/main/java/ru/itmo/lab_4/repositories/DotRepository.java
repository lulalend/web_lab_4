package ru.itmo.lab_4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.lab_4.entities.Dot;

import java.util.List;

public interface DotRepository extends JpaRepository<Dot, Integer> {

    List<Dot> findByUsername(String username);

    void deleteAllByUsername(String username);

}
