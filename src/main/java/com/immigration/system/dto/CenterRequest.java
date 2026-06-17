package com.immigration.system.dto;


public class CenterRequest {

    //Declaring variables
    private String name;
    private String locationCountry;
    private String type;
    private int dailyCapacity;

    public CenterRequest() {}


    //Setter & getter methods
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocationCountry() { return locationCountry; }
    public void setLocationCountry(String locationCountry) { this.locationCountry = locationCountry; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public int getDailyCapacity() { return dailyCapacity; }
    public void setDailyCapacity(int dailyCapacity) { this.dailyCapacity = dailyCapacity; }
}
