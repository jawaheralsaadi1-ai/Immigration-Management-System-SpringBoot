package com.immigration.system.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Applicant extends Person {
    //Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Declaring Variables
    private Long id;
    private String passportNumber;
    private String nationality;
    private boolean criminalRecord;
}
