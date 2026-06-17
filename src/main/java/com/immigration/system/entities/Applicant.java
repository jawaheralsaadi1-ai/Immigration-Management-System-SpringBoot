package com.immigration.system.entities;
import jakarta.persistence.*;
import java.util.ArrayList;

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

    public Long getId() {
        return id;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public boolean isCriminalRecord() {
        return criminalRecord;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setCriminalRecord(boolean criminalRecord) {
        this.criminalRecord = criminalRecord;
    }
}
