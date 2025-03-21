package org.example.docworkstation.patient.exceptions;

public class DuplicatePatientException extends RuntimeException {
    public DuplicatePatientException(String message) {
        super(message);
    }
}
