package ru.itmo.lab_4.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.lab_4.entities.Dot;
import ru.itmo.lab_4.entities.User;
import ru.itmo.lab_4.handlers.HitChecker;
import ru.itmo.lab_4.repositories.DotRepository;
import ru.itmo.lab_4.repositories.UserRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Service
public class DotServiceImpl implements DotService {

    private static final ZoneOffset UTC_TIMEZONE = ZoneOffset.of("+0");
    private final DotRepository dotRepository;
    private final UserRepository userRepository;
    private final HitChecker hitChecker;

    @Autowired
    public DotServiceImpl(DotRepository dotRepository,
                          UserRepository userRepository,
                          HitChecker hitChecker) {
        this.userRepository = userRepository;
        this.dotRepository = dotRepository;
        this.hitChecker = hitChecker;
    }

    @Override
    public Dot enrichDot(Dot dot, String username) {
        dot.setHitResult( this.hitChecker.checkHit(dot) );
        dot.setClientDate(OffsetDateTime.now(UTC_TIMEZONE));
        dot.setExecutionTime(BigDecimal
                .valueOf((System.nanoTime() - dot.getStartTime())/1000000d)
                .setScale(2, RoundingMode.DOWN));
        dot.setUsername(userRepository.findByUsername(username));
        return dot;
    }

    @Override
    public List<Dot> getAllDotsByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return this.dotRepository.findByUsername(user);
    }

    @Override
    public void deleteAllDotsByUsername(String username) {
        this.dotRepository.deleteAllByUsername(username);
    }

    @Override
    public void saveDot(Dot dot) {
        this.dotRepository.save(dot);
    }

}
