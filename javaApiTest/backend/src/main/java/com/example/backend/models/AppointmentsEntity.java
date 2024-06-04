package com.example.backend.models;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_appointments")
public class AppointmentsEntity extends RepresentationModel<AppointmentsEntity> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID appointment_id;
    // @JoinColumn(name = "patient_id")
    // private PatientsEntity patient_id;
    // @JoinColumn(name = "doctor_id")
    // private DoctorsEntity doctor_id;
    private LocalDateTime datetime;
    private String status;
    private String notes;
}
