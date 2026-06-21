package com.immigration.system.dto.responses;

public class AsylumSeekerResponse extends ApplicantResponse {

    //Declaring varables
    private String countryOfOrigin;
    private String sponsorOrganization;

    public AsylumSeekerResponse() {}
// Constructor
    public AsylumSeekerResponse(String id, String firstName, String lastName, String gender,
                                String phoneNumber, String email, String passportNumber,
                                String nationality, boolean criminalRecord,
                                String countryOfOrigin, String sponsorOrganization) {
        super(id, firstName, lastName, gender, phoneNumber, email, passportNumber, nationality, criminalRecord);
        this.countryOfOrigin = countryOfOrigin;
        this.sponsorOrganization = sponsorOrganization;
    }

//getter & setter methods
    public String getCountryOfOrigin() { return countryOfOrigin; }
    public void setCountryOfOrigin(String countryOfOrigin) { this.countryOfOrigin = countryOfOrigin; }

    public String getSponsorOrganization() { return sponsorOrganization; }
    public void setSponsorOrganization(String sponsorOrganization) { this.sponsorOrganization = sponsorOrganization; }
}