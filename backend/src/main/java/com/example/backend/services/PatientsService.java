package com.example.backend.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.backend.controllers.PatientsController;
import com.example.backend.dtos.PatientsRecordDTO;
import com.example.backend.models.PatientsEntity;
import com.example.backend.repositories.PatientsRepository;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class PatientsService {
    @Autowired
    private PatientsRepository patientsRepository;

    public ResponseEntity<PatientsEntity> savePatient(PatientsRecordDTO patientsRecordDTO) {
        PatientsEntity patientsEntity = new PatientsEntity();
        BeanUtils.copyProperties(patientsRecordDTO, patientsEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(patientsRepository.save(patientsEntity));
    }
    
    public ResponseEntity<List<PatientsEntity>> getAllPatients() {
        List<PatientsEntity> patientsEntities = patientsRepository.findAll();
        if(!patientsEntities.isEmpty()) {
            for(PatientsEntity patientsEntity : patientsEntities) {
                UUID patient_id = patientsEntity.getPatient_id();
                patientsEntity.add(linkTo(methodOn(PatientsController.class).getPatientById(patient_id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(patientsEntities);
    }
    
    public ResponseEntity<Object> getPatientById(UUID patient_id) {
        Optional<PatientsEntity> patient = patientsRepository.findById(patient_id);
        if(patient.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum paciente com este id");
        }
        patient.get().add(linkTo(methodOn(PatientsController.class).getAllPatients()).withRel("Lista de pacientes"));
        return ResponseEntity.status(HttpStatus.OK).body(patient); 
    }

    public ResponseEntity<Object> updatePatietById(UUID patient_id, PatientsRecordDTO patientsRecordDTO) {
        Optional<PatientsEntity> patient = patientsRepository.findById(patient_id);
        if(patient.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum paciente com este id");
        }
        PatientsEntity patientsEntity = patient.get();
        BeanUtils.copyProperties(patientsRecordDTO, patientsEntity);
        return ResponseEntity.status(HttpStatus.OK).body(patientsRepository.save(patientsEntity));
    }

    public ResponseEntity<Object> deletePatientById(UUID patient_id) {
        Optional<PatientsEntity> patient = patientsRepository.findById(patient_id);
        if(patient.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum paciente com este id");
        }
        patientsRepository.delete(patient.get());
        return ResponseEntity.status(HttpStatus.OK).body(patient);
    }
}
