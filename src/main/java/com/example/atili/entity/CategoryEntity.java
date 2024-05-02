package com.example.atili.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "categoryEntity")
@Getter
@Setter
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    public CategoryEntity() {}

    public CategoryEntity(String name) {
        this.name = name;
    }
}

