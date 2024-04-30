package com.example.atili.service;

import com.example.atili.entity.ClothesEntity;
import com.example.atili.repository.ClothesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClothesService {

    @Autowired
    private ClothesRepository clothesRepository;

    public List<ClothesEntity> getAllClothes() {
        return clothesRepository.findAll();
    }

    public ClothesEntity getClothesById(Long id) {
        return clothesRepository.findById(id).orElse(null);
    }

    public ClothesEntity saveClothes(ClothesEntity clothes) {
        return clothesRepository.save(clothes);
    }

    public void deleteClothes(Long id) {
        clothesRepository.deleteById(id);
    }
}
