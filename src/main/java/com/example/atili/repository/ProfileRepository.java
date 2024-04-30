package com.example.atili.repository;

import com.example.atili.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    // Profilega maxsus boshqa metodlar kerak bo'lsa, ularni bu interfacega qo'shishingiz mumkin
}
