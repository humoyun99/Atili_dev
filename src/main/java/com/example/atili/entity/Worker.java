package com.example.atili.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "workers")
@Getter
@Setter
public class Worker {

    @SequenceGenerator(
            name = "workers_sequence",
            sequenceName = "profile_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(strategy = SEQUENCE,
            generator = "workers_sequence" )
    private Long id;

    private String name;

    private String surname;

    @Column(unique = true)
    private String email;

    private String password;

    private String role;

    private String status;

    private double salary;

    private LocalDateTime born;

    private LocalDateTime timeGetWork;

    private LocalDateTime timeOffWork;

    // constructors, getters, and setters
}
