package ru.itmo.lab_4.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class DotResponseDTO {

    private BigDecimal r;

    private BigDecimal x;

    private BigDecimal y;

    private boolean hitResult;

    private OffsetDateTime clientDate;

    private BigDecimal executionTime;

}
