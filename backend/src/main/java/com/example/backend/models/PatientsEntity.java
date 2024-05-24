package com.example.backend.models;

import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_patients")
public class PatientsEntity extends RepresentationModel<PatientsEntity> {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID patient_id;
    // private UsersEntity user_id;
    private String name;
    private String specialization;
    private String hospital_affiliation;
}
