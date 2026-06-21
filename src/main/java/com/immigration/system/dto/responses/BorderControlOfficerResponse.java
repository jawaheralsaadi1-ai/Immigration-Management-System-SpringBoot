package com.immigration.system.dto.responses;

public class BorderControlOfficerResponse extends OfficerResponse {

    private String assignedCheckpoint;
    private boolean k9UnitAssigned;

    public BorderControlOfficerResponse() {}

    public BorderControlOfficerResponse(Long id, String firstName, String lastName, String gender,
                                           String phoneNumber, String email, String badgeNumber,
                                           String rank, int clearanceLevel, boolean active,
                                           Long centerId, String centerName,
                                           String assignedCheckpoint, boolean k9UnitAssigned) {
        super(id, firstName, lastName, gender, phoneNumber, email, badgeNumber,
                rank, clearanceLevel, active, centerId, centerName);
        this.assignedCheckpoint = assignedCheckpoint;
        this.k9UnitAssigned = k9UnitAssigned;
    }

    public String getAssignedCheckpoint() { return assignedCheckpoint; }
    public void setAssignedCheckpoint(String assignedCheckpoint) { this.assignedCheckpoint = assignedCheckpoint; }

    public boolean isK9UnitAssigned() { return k9UnitAssigned; }
    public void setK9UnitAssigned(boolean k9UnitAssigned) { this.k9UnitAssigned = k9UnitAssigned; }
}