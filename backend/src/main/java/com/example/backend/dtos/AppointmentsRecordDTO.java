package com.example.backend.dtos;

import java.time.LocalDateTime;

import com.example.backend.models.DoctorEntity;
import com.example.backend.models.PatientsEntity;

public record AppointmentsRecordDTO(
    PatientsEntity patient_id,
    DoctorEntity doctor_id,
    LocalDateTime datetime,
    String status,
    String notes
) {
    
}
