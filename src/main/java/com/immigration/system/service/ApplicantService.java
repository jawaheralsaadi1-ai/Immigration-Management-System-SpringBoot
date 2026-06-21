package com.immigration.system.service;


import com.immigration.system.entities.Applicant;
import com.immigration.system.entities.AsylumSeeker;
import com.immigration.system.entities.Interview;
import com.immigration.system.dto.exceptions.ResourceNotFoundException;
import com.immigration.system.dto.exceptions.ValidationException;
import com.immigration.system.repository.ApplicantRepository;
import com.immigration.system.repository.InterviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Service handling all business logic for Applicants.
 * Manual if/else validation is used throughout — no DTOs or validation frameworks.
 */
@Service
public class ApplicantService {

    private final ApplicantRepository applicantRepository;
    private final InterviewRepository interviewRepository;

    public ApplicantService(ApplicantRepository applicantRepository,
                            InterviewRepository interviewRepository) {
        this.applicantRepository = applicantRepository;
        this.interviewRepository = interviewRepository;
    }

    // Manual Validation Helper
    private void validateApplicant(String firstName, String lastName, String passportNumber) {
        if (passportNumber == null || passportNumber.trim().isEmpty()) {
            throw new ValidationException("passportNumber", passportNumber,
                    "Passport number must not be null or empty.");
        }
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new ValidationException("firstName", firstName,
                    "First name must not be null or empty.");
        }
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new ValidationException("lastName", lastName,
                    "Last name must not be null or empty.");
        }
    }

    // Overloaded saveApplicant (Method Overloading – OOP)

    /** Save an existing Applicant object after validation. */
    public Applicant saveApplicant(Applicant applicant) {
        validateApplicant(
                applicant.getFirstName(),
                applicant.getLastName(),
                applicant.getPassportNumber()
        );
        return applicantRepository.save(applicant);
    }

    /**
     * Create and save a new Applicant from raw strings.
     * Demonstrates method overloading.
     */
    public Applicant saveApplicant(String firstName, String lastName,
                                   String passportNumber, String nationality) {
        validateApplicant(firstName, lastName, passportNumber);
        Applicant applicant = new Applicant();
        applicant.setFirstName(firstName);
        applicant.setLastName(lastName);
        applicant.setPassportNumber(passportNumber);
        applicant.setNationality(nationality);
        return applicantRepository.save(applicant);
    }

    // Save AsylumSeeker
    public AsylumSeeker saveAsylumSeeker(AsylumSeeker seeker) {
        validateApplicant(
                seeker.getFirstName(),
                seeker.getLastName(),
                seeker.getPassportNumber()
        );
        return (AsylumSeeker) applicantRepository.save(seeker);
    }

    //  Business Logic


    public Applicant flagCriminalRecord(Long applicantId) {
        Applicant applicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> new ResourceNotFoundException("Applicant", "id", applicantId));

        applicant.setCriminalRecord(true);
        applicantRepository.save(applicant);

        // Cancel all scheduled interviews for this applicant
        List<Interview> interviews = interviewRepository.findByApplicantId(applicantId);
        for (Interview interview : interviews) {
            if ("SCHEDULED".equals(interview.getStatus())) {
                interview.setStatus("CANCELLED");
                interviewRepository.save(interview);
            }
        }
        //

        return applicant;
    }

    //  Read Operations
    public List<Applicant> getAllApplicants() {
        return applicantRepository.findAll();
    }

    public Applicant getApplicantById(Long id) {
        return applicantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Applicant", "id", id));
    }

    public List<Applicant> getApplicantsByNationality(String nationality) {
        if (nationality == null || nationality.trim().isEmpty()) {
            throw new ValidationException("nationality", nationality,
                    "Nationality search parameter must not be empty.");
        }
        return applicantRepository.findByNationality(nationality);
    }
}

