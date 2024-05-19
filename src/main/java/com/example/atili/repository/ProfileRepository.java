package com.example.atili.repository;

import com.example.atili.entity.ProfileEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends CrudRepository<ProfileEntity,Long> {
    Optional<ProfileEntity> findByEmail(String email);
}
