package com.immigration.system.dto.requests;


public class VisaApplicationRequest {

    private Long applicantId;
    private String visaType;
    private String officerNotes;
    private String status;

    public VisaApplicationRequest() {}

    public Long getApplicantId() { return applicantId; }
    public void setApplicantId(Long applicantId) { this.applicantId = applicantId; }

    public String getOfficerNotes() {return officerNotes;}
    public void setOfficerNotes(String officerNotes) {this.officerNotes = officerNotes;}

    public String getStatus() {return status;}
    public void setStatus(String status) { this.status = status; }

    public String getVisaType() { return visaType; }
    public void setVisaType(String visaType) { this.visaType = visaType; }
}