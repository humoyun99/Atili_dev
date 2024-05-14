package com.example.atili.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "cards")
@Getter
@Setter
public class CardEntity {

    @SequenceGenerator(
            name = "cards_sequence",
            sequenceName = "cards_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(strategy = SEQUENCE,
            generator = "cards_sequence" )
    private Long id;

    @Column(unique = true)
    private String number;

    private String status;

    private double money;

    // Constructors, getters, and setters
}

