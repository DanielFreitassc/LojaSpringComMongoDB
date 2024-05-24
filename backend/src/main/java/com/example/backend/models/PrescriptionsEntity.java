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
@Table(name = "tb_prescription")
public class PrescriptionsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID prescription_id;
    @JoinColumn(name = "appointment_id")
    private AppointmentsEntity appointment_id;
    private String medication;
    private String dosage;
    private String frequency;
    private String start_date;
    private String end_date;
}
