package org.example.docworkstation.patient.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.docworkstation.patient.dtos.CreatePatientRequest;
import org.example.docworkstation.patient.dtos.CreatePatientResponse;
import org.example.docworkstation.patient.services.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/patient")
public class PatientController {
    private final PatientService _patientService;

    public PatientController(PatientService patientService) {
        _patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<CreatePatientResponse> createPatient(
            @Valid @RequestBody CreatePatientRequest request) {
        CreatePatientResponse response = _patientService.createPatient(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
}
}
