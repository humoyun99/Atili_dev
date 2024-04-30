package com.example.atili.service;

import com.example.atili.entity.CardEntity;
import com.example.atili.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public List<CardEntity> getAllCards() {
        return cardRepository.findAll();
    }

    public CardEntity getCardById(Long id) {
        return cardRepository.findById(id).orElse(null);
    }

    public CardEntity saveCard(CardEntity card) {
        return cardRepository.save(card);
    }

    public void deleteCard(Long id) {
        cardRepository.deleteById(id);
    }
}
