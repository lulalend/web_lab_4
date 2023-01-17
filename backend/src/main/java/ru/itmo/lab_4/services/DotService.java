package ru.itmo.lab_4.services;

import ru.itmo.lab_4.entities.Dot;

import java.util.List;

public interface DotService {
    Dot enrichDot(Dot dot);

    List<Dot> getAllDotsByUsername(String username);

    void deleteAllDotsByUsername(String username);

    void saveDot(Dot hitCheck);
}
