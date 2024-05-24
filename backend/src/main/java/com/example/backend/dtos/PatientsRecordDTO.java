package com.example.backend.dtos;

import com.example.backend.models.UsersEntity;

public record PatientsRecordDTO(
    UsersEntity user_id,
    String name,
    String specialization,
    String hospital_affiliation
) {
    
}
