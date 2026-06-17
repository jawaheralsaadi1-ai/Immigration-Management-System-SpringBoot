package com.immigration.system.dto.requests;


public class ApplicantRequest {

    //Declaring variables
    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNumber;
    private String email;
    private String passportNumber;
    private String nationality;

    public ApplicantRequest() {}

    //Constructor
    public ApplicantRequest(String firstName, String lastName, String gender,
                               String phoneNumber, String email,
                               String passportNumber, String nationality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.passportNumber = passportNumber;
        this.nationality = nationality;
    }

    // getter & setter methods
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassportNumber() { return passportNumber; }
    public void setPassportNumber(String passportNumber) { this.passportNumber = passportNumber; }

    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { this.nationality = nationality; }
}
