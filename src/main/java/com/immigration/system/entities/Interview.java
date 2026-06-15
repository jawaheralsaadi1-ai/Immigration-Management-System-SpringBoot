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
}
