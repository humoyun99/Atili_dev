package com.example.atili.controler;

import com.example.atili.entity.ClothesEntity;
import com.example.atili.service.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clothes")
public class ClothesController {

    @Autowired
    private ClothesService clothesService;

    @GetMapping("")
    public ResponseEntity<List<ClothesEntity>> getAllClothes() {
        List<ClothesEntity> clothes = clothesService.getAllClothes();
        return ResponseEntity.ok(clothes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClothesEntity> getClothesById(@PathVariable("id") Long id) {
        ClothesEntity clothes = clothesService.getClothesById(id);
        if (clothes != null) {
            return ResponseEntity.ok(clothes);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ClothesEntity> createClothes(@RequestBody ClothesEntity clothes) {
        ClothesEntity createdClothes = clothesService.saveClothes(clothes);
        return new ResponseEntity<>(createdClothes, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClothes(@PathVariable("id") Long id) {
        clothesService.deleteClothes(id);
        return ResponseEntity.noContent().build();
    }
}

