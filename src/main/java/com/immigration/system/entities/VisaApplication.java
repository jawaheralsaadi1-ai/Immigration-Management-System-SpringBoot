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

}
