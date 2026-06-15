package com.immigration.system.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ImmigrationOfficer extends  Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //Declaring variables
    private Long id;
    private String badgeNumber;
    private String rank;
    private int clearanceLevel;
    private boolean active;
}
