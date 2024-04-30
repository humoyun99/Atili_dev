package com.example.atili.repository;

import com.example.atili.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {
    // Optional<Worker> findByEmail(String email);
}
