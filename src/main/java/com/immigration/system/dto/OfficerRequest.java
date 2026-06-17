package com.immigration.system.dto;

public class OfficerRequest {

    //Declaring variables
    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNumber;
    private String email;
    private String badgeNumber;
    private String rank;
    private int clearanceLevel;
    private Long Id;
    private boolean active;


    public OfficerRequest() {}


    //Setter & getter methods
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

    public String getBadgeNumber() { return badgeNumber; }
    public void setBadgeNumber(String badgeNumber) { this.badgeNumber = badgeNumber; }

    public String getRank() { return rank; }
    public void setRank(String rank) { this.rank = rank; }

    public int getClearanceLevel() { return clearanceLevel; }
    public void setClearanceLevel(int clearanceLevel) { this.clearanceLevel = clearanceLevel; }

    public Long getId() { return Id; }
    public void setId(Long Id) { this.Id = Id; }

    public boolean isActive() {return active;}
    public void setActive(boolean active) {this.active = active;}
}
