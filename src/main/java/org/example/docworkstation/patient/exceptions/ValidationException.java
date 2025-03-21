package org.example.docworkstation.patient.exceptions;

public class ValidationException extends RuntimeException {
  public ValidationException(String message) {
    super(message);
  }
}