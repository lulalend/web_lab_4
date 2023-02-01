package ru.itmo.lab_4.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Getter
@Setter
public class DotRequestDTO {

    @Positive
    @NotNull
    private BigDecimal r;

    @NotNull
    private BigDecimal x;

    @NotNull
    private BigDecimal y;
}
