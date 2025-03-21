package org.example.docworkstation.patient;

import org.example.docworkstation.common.dtos.ErrorResponse;
import org.example.docworkstation.patient.exceptions.DuplicatePatientException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PatientExceptionHandler {

    @ExceptionHandler(DuplicatePatientException.class)
    public ResponseEntity<ErrorResponse> handleDuplicatePatientException(DuplicatePatientException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErrorResponse(ex.getMessage()));
    }
}
