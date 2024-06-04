package com.example.backend.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.models.PrescriptionsEntity;

public interface PrescriptionRepository extends JpaRepository<PrescriptionsEntity, UUID>{
    
}
