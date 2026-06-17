package com.immigration.system.dto;



public class BorderControlOfficerRequest extends OfficerRequest {

    private String assignedCheckpoint;
    private boolean k9UnitAssigned;

    public BorderControlOfficerRequest() {}

    public String getAssignedCheckpoint() { return assignedCheckpoint; }
    public void setAssignedCheckpoint(String assignedCheckpoint) { this.assignedCheckpoint = assignedCheckpoint; }

    public boolean isK9UnitAssigned() { return k9UnitAssigned; }
    public void setK9UnitAssigned(boolean k9UnitAssigned) { this.k9UnitAssigned = k9UnitAssigned; }
}
