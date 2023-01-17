package ru.itmo.lab_4.handlers;

import org.springframework.stereotype.Component;
import ru.itmo.lab_4.entities.Dot;

import java.math.BigDecimal;

//ПЕРЕДЕЛАТЬ ИСХОДЯ ИЗ КАРТИНКИ ПО ВАРИАНТУ
@Component
public class HitChecker {
    private static final BigDecimal ZERO = new BigDecimal("0");
    private static final BigDecimal TWO = new BigDecimal("2");

    public boolean checkHit(Dot dot) {

        BigDecimal r = dot.getR(),
                x = dot.getX(),
                y = dot.getY();

        //noinspection BigDecimalMethodWithoutRoundingCalled
        BigDecimal semiR = r.divide(TWO);

        boolean firstQuarterTriangle = ( x.compareTo(ZERO) >= 0 && y.compareTo(ZERO) >= 0 &&
                (y.add(x.multiply(TWO)).compareTo(r) <= 0) );

        boolean secondQuarterCircle = ( x.compareTo(ZERO) <= 0 && y.compareTo(ZERO) >= 0 &&
                ((x.multiply(x)).add(y.multiply(y)).compareTo(semiR.multiply(semiR)) <= 0) );

        boolean thirdQuarterRectangle = ( x.compareTo(ZERO) >= 0 && x.compareTo(r) <= 0 &&
                y.compareTo(ZERO) <= 0 && y.compareTo(semiR.negate()) >= 0 );

        return firstQuarterTriangle || secondQuarterCircle || thirdQuarterRectangle;
    }
}
