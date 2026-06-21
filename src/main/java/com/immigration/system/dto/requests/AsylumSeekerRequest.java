package com.immigration.system.dto.requests;


public class AsylumSeekerRequest extends ApplicantRequest {

    //Declaring variables fields
    private String countryOfOrigin;
    private String sponsorOrganization;

    public AsylumSeekerRequest() {}


    //Constructor
    public AsylumSeekerRequest(String firstName, String lastName, String gender,
                                  String phoneNumber, String email,
                                  String passportNumber, String nationality,
                                  String countryOfOrigin, String sponsorOrganization) {
        super(firstName, lastName, gender, phoneNumber, email, passportNumber, nationality);
        this.countryOfOrigin = countryOfOrigin;
        this.sponsorOrganization = sponsorOrganization;
    }

    //getter and setter methods

    public String getCountryOfOrigin() { return countryOfOrigin; }
    public void setCountryOfOrigin(String countryOfOrigin) { this.countryOfOrigin = countryOfOrigin; }

    public String getSponsorOrganization() { return sponsorOrganization; }
    public void setSponsorOrganization(String sponsorOrganization) { this.sponsorOrganization = sponsorOrganization; }
}