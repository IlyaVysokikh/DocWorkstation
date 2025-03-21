package org.example.docworkstation.patient.services;

import org.example.docworkstation.patient.dtos.CreatePatientRequest;
import org.example.docworkstation.patient.dtos.CreatePatientResponse;
import org.example.docworkstation.patient.exceptions.DuplicatePatientException;
import org.example.docworkstation.patient.exceptions.ValidationException;
import org.example.docworkstation.patient.models.Patient;
import org.example.docworkstation.patient.repositories.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    private final PatientRepository _patientRepository;

    public PatientService(PatientRepository patientRepository) {
        _patientRepository = patientRepository;
    }

    public CreatePatientResponse createPatient(CreatePatientRequest request) {
        if (_patientRepository.existsBySnils(request.snils())) {
            throw new DuplicatePatientException("Patient with SNILS " + request.snils() + " already exists");
        }

        if (!isValidSnils(request.snils())) {
            throw new ValidationException("Invalid SNILS format");
        }

        Patient patient = new Patient(
                request.firstName(),
                request.middleName(),
                request.lastName(),
                request.birthDate(),
                request.snils(),
                request.oms()
        );

        Patient savedPatient = _patientRepository.save(patient);
        return new CreatePatientResponse(savedPatient.getId(), "Patient created successfully");
    }

    private boolean isValidSnils(String snils) {
        return snils != null && snils.matches("^\\d{3}-\\d{3}-\\d{3}-\\d{2}$");
    }
}
