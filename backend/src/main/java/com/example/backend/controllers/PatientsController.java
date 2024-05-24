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

import com.example.backend.dtos.PatientsRecordDTO;
import com.example.backend.models.PatientsEntity;
import com.example.backend.services.PatientsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("patients")
public class PatientsController {
    @Autowired
    private PatientsService patientsService;

    @PostMapping
    public ResponseEntity<PatientsEntity> savePatient(@RequestBody @Valid PatientsRecordDTO patientsRecordDTO) {
        return patientsService.savePatient(patientsRecordDTO);
    }

    @GetMapping
    public ResponseEntity<List<PatientsEntity>> getAllPatients() {
        return patientsService.getAllPatients();
    }

    @GetMapping("{patient_id}")
    public ResponseEntity<Object> getPatientById(@PathVariable(value = "patient_id") UUID patient_id) {
        return patientsService.getPatientById(patient_id);
    }

    @PutMapping("{patient_id}")
    public ResponseEntity<Object> updatePatietById(@PathVariable(value = "patient_id")UUID patient_id, @RequestBody @Valid PatientsRecordDTO patientsRecordDTO) {
        return patientsService.updatePatietById(patient_id, patientsRecordDTO);
    }

    @DeleteMapping("{patient_id}")
    public ResponseEntity<Object> deleteEntity(@PathVariable(value = "patient_id")UUID id) {
        return patientsService.deletePatientById(id);
    }
}
