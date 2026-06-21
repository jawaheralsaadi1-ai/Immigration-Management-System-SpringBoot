package com.immigration.system.entities;
import jakarta.persistence.Entity;

@Entity
public class BorderControlOfficer extends ImmigrationOfficer {

    //Declaring variables
    private String assignedCheckpoint;
    private boolean k9UnitAssigned;

    //Constructor

    public BorderControlOfficer(String assignedCheckpoint, boolean k9UnitAssigned) {
        this.assignedCheckpoint = assignedCheckpoint;
        this.k9UnitAssigned = k9UnitAssigned;
    }
    //Getters & Setters

    public String getAssignedCheckpoint() {
        return assignedCheckpoint;
    }

    public boolean isK9UnitAssigned() {
        return k9UnitAssigned;
    }

    public void setAssignedCheckpoint(String assignedCheckpoint) {
        this.assignedCheckpoint = assignedCheckpoint;
    }

    public void setK9UnitAssigned(boolean k9UnitAssigned) {
        this.k9UnitAssigned = k9UnitAssigned;
    }
}
