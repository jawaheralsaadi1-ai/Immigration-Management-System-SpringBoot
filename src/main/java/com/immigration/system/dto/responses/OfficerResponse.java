package com.immigration.system.dto.responses;

public class OfficerResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNumber;
    private String email;
    private String badgeNumber;
    private String rank;
    private int clearanceLevel;
    private boolean active;
    private Long centerId;
    private String centerName;

    public OfficerResponse() {}

    public OfficerResponse(Long id, String firstName, String lastName, String gender,
                              String phoneNumber, String email, String badgeNumber,
                              String rank, int clearanceLevel, boolean active,
                              Long centerId, String centerName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.badgeNumber = badgeNumber;
        this.rank = rank;
        this.clearanceLevel = clearanceLevel;
        this.active = active;
        this.centerId = centerId;
        this.centerName = centerName;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public Long getCenterId() { return centerId; }
    public void setCenterId(Long centerId) { this.centerId = centerId; }

    public String getCenterName() { return centerName; }
    public void setCenterName(String centerName) { this.centerName = centerName; }
}