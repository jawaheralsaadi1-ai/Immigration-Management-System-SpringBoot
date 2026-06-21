package com.immigration.system.entities;
import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class AsylumSeeker extends Applicant {

    // Declaring Variables
    private String countryOfOrigin;
    private String sponsorOrganization;

    //constructor
    public AsylumSeeker() {}

    public AsylumSeeker(String countryOfOrigin, String sponsorOrganization) {
        this.countryOfOrigin = countryOfOrigin;
        this.sponsorOrganization = sponsorOrganization;
    }

    public AsylumSeeker(Long id, String passportNumber, String nationality, boolean criminalRecord, List<VisaApplication> visaApplications, List<Interview> interviews, String countryOfOrigin, String sponsorOrganization) {
        super(id, passportNumber, nationality, criminalRecord, visaApplications, interviews);
        this.countryOfOrigin = countryOfOrigin;
        this.sponsorOrganization = sponsorOrganization;
    }

    public AsylumSeeker(String firstName, String lastName, String gender, String phoneNumber, String email, Long id, String passportNumber, String nationality, boolean criminalRecord, List<VisaApplication> visaApplications, List<Interview> interviews, String countryOfOrigin, String sponsorOrganization) {
        super(firstName, lastName, gender, phoneNumber, email, id, passportNumber, nationality, criminalRecord, visaApplications, interviews);
        this.countryOfOrigin = countryOfOrigin;
        this.sponsorOrganization = sponsorOrganization;
    }
    //Getters & Setters

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public String getSponsorOrganization() {
        return sponsorOrganization;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public void setSponsorOrganization(String sponsorOrganization) {
        this.sponsorOrganization = sponsorOrganization;
    }
}

