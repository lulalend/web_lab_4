package ru.itmo.lab_4.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "authorities")
public class UserAuth {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "username",
            referencedColumnName = "username")
    private User user;

    @Column(name = "authority")
    private String authority;

    public UserAuth() {
    }

}
