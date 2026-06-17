package com.immigration.system.dto.responses;

public class CenterResponse {

    private Long id;
    private String name;
    private String locationCountry;
    private String type;
    private int dailyCapacity;
    private int officerCount;

    public CenterResponse() {}

    public CenterResponse(Long id, String name, String locationCountry,
                             String type, int dailyCapacity, int officerCount) {
        this.id = id;
        this.name = name;
        this.locationCountry = locationCountry;
        this.type = type;
        this.dailyCapacity = dailyCapacity;
        this.officerCount = officerCount;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocationCountry() { return locationCountry; }
    public void setLocationCountry(String locationCountry) { this.locationCountry = locationCountry; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public int getDailyCapacity() { return dailyCapacity; }
    public void setDailyCapacity(int dailyCapacity) { this.dailyCapacity = dailyCapacity; }

    public int getOfficerCount() { return officerCount; }
    public void setOfficerCount(int officerCount) { this.officerCount = officerCount; }
}