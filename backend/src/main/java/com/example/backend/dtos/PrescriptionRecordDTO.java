package com.example.backend.dtos;

import com.example.backend.models.AppointmentsEntity;

public record PrescriptionRecordDTO (
    AppointmentsEntity appointment_id,
    String medication,
    String dosage,
    String frequency,
    String start_date,
    String end_date
) {
    
}
