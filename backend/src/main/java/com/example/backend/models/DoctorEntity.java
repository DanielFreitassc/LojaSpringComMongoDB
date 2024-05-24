package com.example.backend.models;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_doctors")
public class DoctorEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID doctor_id;
    @JoinColumn(name = "user_id")
    private  UsersEntity user_id;
    private String name;
    private String specialization;
    private String hospital_affiliation;
}
