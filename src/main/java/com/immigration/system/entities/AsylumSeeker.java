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

