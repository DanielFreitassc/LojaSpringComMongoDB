package com.example.backend.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.backend.controllers.DoctorsController;
import com.example.backend.dtos.DoctorsRecordDTO;
import com.example.backend.models.DoctorsEntity;
import com.example.backend.repositories.DoctorsRepository;

@Service
public class DoctorsService {
    @Autowired
    private DoctorsRepository doctorsRepository;

    public ResponseEntity<DoctorsEntity> saveDoctor(DoctorsRecordDTO doctorsRecordDTO) {
        DoctorsEntity doctorsEntity = new DoctorsEntity();
        BeanUtils.copyProperties(doctorsRecordDTO, doctorsEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(doctorsRepository.save(doctorsEntity));
    }

    public ResponseEntity<List<DoctorsEntity>> getAllDoctors() {
        List<DoctorsEntity> doctors = doctorsRepository.findAll();
        if(!doctors.isEmpty()) {
            for(DoctorsEntity doctorsEntity : doctors) {
                UUID doctor_id = doctorsEntity.getDoctor_id();
                doctorsEntity.add(linkTo(methodOn(DoctorsController.class).getDoctorById(doctor_id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(doctors);
    }

    public ResponseEntity<Object> getDoctorById(UUID doctor_id) {
        Optional<DoctorsEntity> doctor = doctorsRepository.findById(doctor_id);
        if(doctor.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum doutor com este id");
        }
        doctor.get().add(linkTo(methodOn(DoctorsController.class).getAllDoctos()).withRel("Lista de doutores"));
        return ResponseEntity.status(HttpStatus.OK).body(doctor);
    }

    public ResponseEntity<Object> updateDoctorById(UUID doctor_id, DoctorsRecordDTO doctorsRecordDTO) {
        Optional<DoctorsEntity> doctor = doctorsRepository.findById(doctor_id);
        if(doctor.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum doutor com este id");
        }
        DoctorsEntity doctorsEntity = doctor.get();
        BeanUtils.copyProperties(doctorsRecordDTO, doctorsEntity);
        return ResponseEntity.status(HttpStatus.OK).body(doctorsRepository.save(doctorsEntity));
    }

    public ResponseEntity<Object> deleteDoctorById(UUID doctor_id) {
        Optional<DoctorsEntity> doctor = doctorsRepository.findById(doctor_id);
        if(doctor.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum doutor com este id");
        }
        doctorsRepository.delete(doctor.get());
        return ResponseEntity.status(HttpStatus.OK).body(doctor);
    }
}
