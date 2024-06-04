package com.example.backend.dtos;

public record UsersRecordDTO (
    String username,
    String password_hash,
    String email,
    String role
) {
    
}
