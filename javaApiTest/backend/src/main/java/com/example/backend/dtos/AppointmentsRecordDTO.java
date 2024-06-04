package com.example.backend.dtos;

import java.time.LocalDateTime;

import com.example.backend.models.DoctorsEntity;
import com.example.backend.models.PatientsEntity;

public record AppointmentsRecordDTO (
    PatientsEntity patient_id,
    DoctorsEntity doctor_id,
    LocalDateTime datetime,
    String status,
    String notes
) {
    
}
