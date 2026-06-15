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
}
