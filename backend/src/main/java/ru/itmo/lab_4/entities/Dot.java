package ru.itmo.lab_4.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "dots")
public class Dot {
    @Transient
    double startTime = System.nanoTime();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "r")
    private BigDecimal r;
    @Column(name = "x")
    private BigDecimal x;
    @Column(name = "y")
    private BigDecimal y;
    @Column(name = "hit_result")
    private boolean hitResult;
    @Column(name = "client_date")
    private OffsetDateTime clientDate;
    @Column(name = "execution_time")
    private BigDecimal executionTime;

    @ManyToOne
    @JoinColumn(name = "username",
            referencedColumnName = "username")
    private User username;

    public Dot() {
    }

    @Override
    public String toString() {
        return "HitCheckEntity{" +
                "id=" + id +
                ", r=" + r +
                ", x=" + x +
                ", y=" + y +
                ", hitResult=" + hitResult +
                ", clientDate=" + clientDate +
                ", executionTime=" + executionTime +
                '}';
    }
}