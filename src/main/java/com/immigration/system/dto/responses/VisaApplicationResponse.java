package com.immigration.system.dto.responses;

public class VisaApplicationResponse {

    private Long id;
    private Long applicantId;
    private String applicantFullName;
    private Long handlingOfficerId;
    private String handlingOfficerFullName;
    private String visaType;
    private String status;
    private String officerNotes;

    public VisaApplicationResponse() {}

    public VisaApplicationResponse(Long id, Long applicantId, String applicantFullName,
                                      Long handlingOfficerId, String handlingOfficerFullName,
                                      String visaType, String status, String officerNotes) {
        this.id = id;
        this.applicantId = applicantId;
        this.applicantFullName = applicantFullName;
        this.handlingOfficerId = handlingOfficerId;
        this.handlingOfficerFullName = handlingOfficerFullName;
        this.visaType = visaType;
        this.status = status;
        this.officerNotes = officerNotes;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getApplicantId() { return applicantId; }
    public void setApplicantId(Long applicantId) { this.applicantId = applicantId; }

    public String getApplicantFullName() { return applicantFullName; }
    public void setApplicantFullName(String applicantFullName) { this.applicantFullName = applicantFullName; }

    public Long getHandlingOfficerId() { return handlingOfficerId; }
    public void setHandlingOfficerId(Long handlingOfficerId) { this.handlingOfficerId = handlingOfficerId; }

    public String getHandlingOfficerFullName() { return handlingOfficerFullName; }
    public void setHandlingOfficerFullName(String handlingOfficerFullName) { this.handlingOfficerFullName = handlingOfficerFullName; }

    public String getVisaType() { return visaType; }
    public void setVisaType(String visaType) { this.visaType = visaType; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getOfficerNotes() { return officerNotes; }
    public void setOfficerNotes(String officerNotes) { this.officerNotes = officerNotes; }
}