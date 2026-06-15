package com.immigration.system.entities;
import jakarta.persistence.Entity;

@Entity
public class AsylumSeeker extends Applicant {

    // Declaring Variables
    private String countryOfOrigin;
    private String sponsorOrganization;

    //constructor
    public AsylumSeeker(String countryOfOrigin, String sponsorOrganization) {
        this.countryOfOrigin = countryOfOrigin;
        this.sponsorOrganization = sponsorOrganization;
    }
}

