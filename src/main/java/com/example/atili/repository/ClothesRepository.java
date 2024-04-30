package com.example.atili.repository;

import com.example.atili.entity.ClothesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothesRepository extends JpaRepository<ClothesEntity, Long> {
}

