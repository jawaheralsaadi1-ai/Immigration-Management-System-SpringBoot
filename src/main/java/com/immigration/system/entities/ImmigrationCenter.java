package com.immigration.system.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


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

}
