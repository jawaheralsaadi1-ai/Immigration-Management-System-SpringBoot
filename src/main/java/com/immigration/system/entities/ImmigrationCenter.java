package com.immigration.system.entities;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class ImmigrationCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //Declaring variables
    private Long id;
    private String name;
    private String locationCountry;
    private String type; // "Embassy", "Border"
    private int dailyCapacity;

    //Officers (@OneToMany ) .
    @OneToMany(mappedBy = "center")
    private List<ImmigrationOfficer> officers = new ArrayList<>();

// Getter method

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocationCountry() {
        return locationCountry;
    }

    public String getType() {
        return type;
    }

    public int getDailyCapacity() {
        return dailyCapacity;
    }

    public List<ImmigrationOfficer> getOfficers() {
        return officers;
    }

    //setter method

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocationCountry(String locationCountry) {
        this.locationCountry = locationCountry;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDailyCapacity(int dailyCapacity) {
        this.dailyCapacity = dailyCapacity;
    }

    public void setOfficers(List<ImmigrationOfficer> officers) {
        this.officers = officers;
    }
}
