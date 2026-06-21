package com.immigration.system.entities;
import jakarta.persistence.*;


@Entity
public class Interview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;
    @ManyToOne @JoinColumn(name = "officer_id")

    //Declaring Variables
    private ImmigrationOfficer officer;
    private String interviewDate; // "YYYY-MM-DD"
    private String status; // "SCHEDULED", "COMPLETED", "CANCELLED"
    private String purpose;

    public Interview() {}

    // Getter method

    public Long getId() {
        return id;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public ImmigrationOfficer getOfficer() {
        return officer;
    }

    public String getInterviewDate() {
        return interviewDate;
    }

    public String getStatus() {
        return status;
    }

    public String getPurpose() {
        return purpose;
    }
    //Setter Method

    public void setId(Long id) {
        this.id = id;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public void setOfficer(ImmigrationOfficer officer) {
        this.officer = officer;
    }

    public void setInterviewDate(String interviewDate) {
        this.interviewDate = interviewDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
