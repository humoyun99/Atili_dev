package com.example.atili.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.SEQUENCE;


@Entity
@Table(name = "clothes")
@Getter
@Setter
public class ClothesEntity {

    @SequenceGenerator(
            name = "clothes_sequence",
            sequenceName = "clothes_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(strategy = SEQUENCE,
            generator = "clothes_sequence" )
    private Long id;

    private String description;

    @Column(name = "the_price")
    private double thePrice;

    private String size;

    @Column(name = "category_id")
    private Integer categoryId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id",updatable = false,insertable = false)
    private CategoryEntity category;

    // Constructors, getters, and setters
}

