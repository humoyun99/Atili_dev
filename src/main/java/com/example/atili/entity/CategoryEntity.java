package com.example.atili.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "category")
@Getter
@Setter
public class CategoryEntity {
    @SequenceGenerator(
            name = "category_sequence",
            sequenceName = "category_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(strategy = SEQUENCE,
                    generator = "cetogory_sequence" )
    private Integer id;
    @Column
    private String name;

    public CategoryEntity() {}

    public CategoryEntity(String name) {
        this.name = name;
    }
}

