package com.immigration.system.dto.requests;

public class InterviewRequest {

    //Declaring variables
    private Long applicantId;
    private Long officerId;
    private String interviewDate;
    private String status;
    private String purpose;

    public InterviewRequest() {}


    //getter & setter methods
    public Long getApplicantId() { return applicantId; }
    public void setApplicantId(Long applicantId) { this.applicantId = applicantId; }

    public Long getOfficerId() { return officerId; }
    public void setOfficerId(Long officerId) { this.officerId = officerId; }

    public String getInterviewDate() { return interviewDate; }
    public void setInterviewDate(String interviewDate) { this.interviewDate = interviewDate; }

    public String getStatus() {return status;}
    public void setStatus(String status) { this.status = status; }

    public String getPurpose() { return purpose; }
    public void setPurpose(String purpose) { this.purpose = purpose; }
}

