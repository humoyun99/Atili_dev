package com.example.atili.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name = "clothes")
@Getter
@Setter
public class ClothesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Column(name = "the_price")
    private double thePrice;

    private String size;

    private String category;

    // Constructors, getters, and setters
}

