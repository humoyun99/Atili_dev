package com.example.atili.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "workers")
@Getter
@Setter
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
