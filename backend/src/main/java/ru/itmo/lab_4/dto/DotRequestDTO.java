package ru.itmo.lab_4.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DotRequestDTO {
//!!!   ВАЛИДАЦИЮ БЫЛО БЫ СЛАВНО ДОБАВИТЬ
    private BigDecimal r;

    private BigDecimal x;

    private BigDecimal y;
}
