package com.immigration.system.dto.responses;

public class InterviewResponse {

    private Long id;
    private Long applicantId;
    private String applicantFullName;
    private Long officerId;
    private String officerFullName;
    private String interviewDate;
    private String status;
    private String purpose;

    public InterviewResponse() {}

    public InterviewResponse(Long id, Long applicantId, String applicantFullName,
                                Long officerId, String officerFullName,
                                String interviewDate, String status, String purpose) {
        this.id = id;
        this.applicantId = applicantId;
        this.applicantFullName = applicantFullName;
        this.officerId = officerId;
        this.officerFullName = officerFullName;
        this.interviewDate = interviewDate;
        this.status = status;
        this.purpose = purpose;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getApplicantId() { return applicantId; }
    public void setApplicantId(Long applicantId) { this.applicantId = applicantId; }

    public String getApplicantFullName() { return applicantFullName; }
    public void setApplicantFullName(String applicantFullName) { this.applicantFullName = applicantFullName; }

    public Long getOfficerId() { return officerId; }
    public void setOfficerId(Long officerId) { this.officerId = officerId; }

    public String getOfficerFullName() { return officerFullName; }
    public void setOfficerFullName(String officerFullName) { this.officerFullName = officerFullName; }

    public String getInterviewDate() { return interviewDate; }
    public void setInterviewDate(String interviewDate) { this.interviewDate = interviewDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getPurpose() { return purpose; }
    public void setPurpose(String purpose) { this.purpose = purpose; }
}