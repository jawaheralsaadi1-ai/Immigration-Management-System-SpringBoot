package com.immigration.system.entities;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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
    @ManyToOne
    @JoinColumn(name = "center_id")
    private ImmigrationCenter center;

    @OneToMany(mappedBy = "officer")
    private List<Interview> interviews = new ArrayList<>();

    //Constructors
    public ImmigrationOfficer() {
    }

    public ImmigrationOfficer(Long id, String badgeNumber, String rank, int clearanceLevel, boolean active, ImmigrationCenter center, List<Interview> interviews) {
        this.id = id;
        this.badgeNumber = badgeNumber;
        this.rank = rank;
        this.clearanceLevel = clearanceLevel;
        this.active = active;
        this.center = center;
        this.interviews = interviews;
    }

    //Getter & Setter


    public Long getId() {
        return id;
    }

    public String getBadgeNumber() {
        return badgeNumber;
    }

    public String getRank() {
        return rank;
    }

    public int getClearanceLevel() {
        return clearanceLevel;
    }

    public boolean isActive() {
        return active;
    }

    public ImmigrationCenter getCenter() {
        return center;
    }

    public List<Interview> getInterviews() {
        return interviews;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBadgeNumber(String badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setClearanceLevel(int clearanceLevel) {
        this.clearanceLevel = clearanceLevel;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setCenter(ImmigrationCenter center) {
        this.center = center;
    }

    public void setInterviews(List<Interview> interviews) {
        this.interviews = interviews;
    }
}
