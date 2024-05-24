package com.example.backend.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.dtos.DoctorsRecordDTO;
import com.example.backend.models.DoctorsEntity;
import com.example.backend.services.DoctorsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("doctors")
public class DoctorsController {
    @Autowired
    private DoctorsService doctorsService;

    @PostMapping
    public ResponseEntity<DoctorsEntity> saveDoctor(@RequestBody @Valid DoctorsRecordDTO doctorsRecordDTO) {
        return doctorsService.saveDoctor(doctorsRecordDTO);
    }

    @GetMapping
    public ResponseEntity<List<DoctorsEntity>> getAllDoctos() {
        return doctorsService.getAllDoctors();
    }

    @GetMapping("{doctor_id}")
    public ResponseEntity<Object> getDoctorById(@PathVariable(value = "doctor_id")UUID doctor_id) {
        return doctorsService.getDoctorById(doctor_id);
    }

    @PutMapping("{doctor_id}")
    public ResponseEntity<Object> updateDoctorById(@PathVariable(value = "doctor_id")UUID doctor_id, @RequestBody @Valid DoctorsRecordDTO doctorsRecordDTO) {
        return doctorsService.updateDoctorById(doctor_id, doctorsRecordDTO);
    }

    @DeleteMapping("{doctor_id}")
    public ResponseEntity<Object> deleteDoctorById(@PathVariable(value = "doctor_id")UUID doctor_id) {
        return doctorsService.deleteDoctorById(doctor_id);
    }
    
}
