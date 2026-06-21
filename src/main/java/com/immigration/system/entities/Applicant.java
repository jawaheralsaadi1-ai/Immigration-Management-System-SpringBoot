package com.immigration.system.entities;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "applicant")
    private List<VisaApplication> visaApplications = new ArrayList<>();

    @ManyToMany(mappedBy = "applicant")
    private List<Interview> interviews = new ArrayList<>();

    //Constructors
    public Applicant() {
    }

    public Applicant(Long id, String passportNumber, String nationality, boolean criminalRecord, List<VisaApplication> visaApplications, List<Interview> interviews) {
        this.id = id;
        this.passportNumber = passportNumber;
        this.nationality = nationality;
        this.criminalRecord = criminalRecord;
        this.visaApplications = visaApplications;
        this.interviews = interviews;
    }

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

    public List<VisaApplication> getVisaApplications() {
        return visaApplications;
    }

    public List<Interview> getInterviews() {
        return interviews;
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

    public void setVisaApplications(List<VisaApplication> visaApplications) {
        this.visaApplications = visaApplications;
    }

    public void setInterviews(List<Interview> interviews) {
        this.interviews = interviews;
    }
}

