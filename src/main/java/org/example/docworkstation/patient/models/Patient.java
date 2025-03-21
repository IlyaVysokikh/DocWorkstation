package org.example.docworkstation.patient.models;

import jakarta.persistence.*;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Table(
        name = "t_patient",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "snils"),
                @UniqueConstraint(columnNames = "oms")
        }
)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = true)
    private String middleName;

    @Column(nullable = false)
    private String lastName;

    private Date birthDate;

    @Column(nullable = false, unique = true)
    private String snils;

    @Column(nullable = false, unique = true)
    private String oms;

    public Patient() {}

    public Patient(String firstName, String middleName, String lastName,
                   Date birthDate, String snils, String oms) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.snils = snils;
        this.oms = oms;
    }

    public Long getId() {
        return id;
    }
}
