package com.immigration.system.entities;
import jakarta.persistence.*;

@Entity
public class VisaApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;
    @ManyToOne
    @JoinColumn(name = "officer_id")

    //Declaring Variables
    private ImmigrationOfficer handlingOfficer;
    private String visaType;
    private String status; // "PENDING", "APPROVED", "REJECTED"
    private String officerNotes;

    //Getter methods

    public Long getId() {
        return id;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public ImmigrationOfficer getHandlingOfficer() {
        return handlingOfficer;
    }

    public String getVisaType() {
        return visaType;
    }

    public String getStatus() {
        return status;
    }

    public String getOfficerNotes() {
        return officerNotes;
    }
    // Setter method

    public void setId(Long id) {
        this.id = id;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public void setHandlingOfficer(ImmigrationOfficer handlingOfficer) {
        this.handlingOfficer = handlingOfficer;
    }

    public void setVisaType(String visaType) {
        this.visaType = visaType;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOfficerNotes(String officerNotes) {
        this.officerNotes = officerNotes;
    }
}
