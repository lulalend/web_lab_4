package ru.itmo.lab_4.handlers;

import org.springframework.stereotype.Component;
import ru.itmo.lab_4.entities.Dot;

import java.math.BigDecimal;
import java.math.RoundingMode;

// TODO ПЕРЕДЕЛАТЬ ИСХОДЯ ИЗ КАРТИНКИ ПО ВАРИАНТУ
@Component
public class HitChecker {
    private static final BigDecimal ZERO = new BigDecimal("0");
    private static final BigDecimal TWO = new BigDecimal("2");

    public boolean checkHit(Dot dot) {

        BigDecimal r = dot.getR(),
                x = dot.getX(),
                y = dot.getY();


        BigDecimal semiR = r.divide(TWO, RoundingMode.CEILING);

        boolean secondQuarterRectangle = ( x.compareTo(ZERO) <= 0 && x.compareTo(semiR.negate()) >= 0 &&
                y.compareTo(ZERO) >= 0 && y.compareTo(r) <= 0 );

        boolean thirdQuarterCircle = ( x.compareTo(ZERO) <= 0 && y.compareTo(ZERO) <= 0 &&
                ((x.multiply(x)).add(y.multiply(y)).compareTo(r.multiply(r)) <= 0) );

        boolean forthQuarterTriangle = ( x.compareTo(ZERO) >= 0 && y.compareTo(ZERO) <= 0 &&
                (y.subtract(x).compareTo(r.negate()) >= 0) );

        return secondQuarterRectangle || thirdQuarterCircle || forthQuarterTriangle;
    }
}
