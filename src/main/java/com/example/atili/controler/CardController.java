package com.example.atili.controler;

import com.example.atili.entity.CardEntity;
import com.example.atili.service.CardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
@Slf4j
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping("")
    public ResponseEntity<List<CardEntity>> getAllCards() {
        List<CardEntity> cards = cardService.getAllCards();
        return ResponseEntity.ok(cards);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardEntity> getCardById(@PathVariable("id") Long id) {
        log.info("Cardni Id boyicha olish {}",id);
        CardEntity card = cardService.getCardById(id);
        if (card != null) {
            return ResponseEntity.ok(card);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<CardEntity> createCard(@RequestBody CardEntity card) {
        CardEntity createdCard = cardService.saveCard(card);
        return new ResponseEntity<>(createdCard, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable("id") Long id) {
        cardService.deleteCard(id);
        return ResponseEntity.noContent().build();
    }
}

