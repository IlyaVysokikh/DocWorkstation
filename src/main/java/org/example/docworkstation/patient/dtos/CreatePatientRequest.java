package org.example.docworkstation.patient.dtos;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record CreatePatientRequest(
        @NotBlank String firstName,
        String middleName,
        @NotBlank String  lastName,
        Date birthDate,
        String snils,
        String oms
        ) {
}
