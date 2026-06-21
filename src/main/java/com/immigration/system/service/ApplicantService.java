package com.immigration.system.service;

import com.immigration.system.entities.Applicant;
import com.immigration.system.entities.AsylumSeeker;
import com.immigration.system.entities.Interview;
import com.immigration.system.repository.ApplicantRepository;
import com.immigration.system.repository.InterviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantService {

    private final ApplicantRepository applicantRepository;
    private final InterviewRepository interviewRepository;

    public ApplicantService(ApplicantRepository applicantRepository, InterviewRepository interviewRepository) {
        this.applicantRepository = applicantRepository;
        this.interviewRepository = interviewRepository;
    }

    private void validateApplicant(String firstName, String lastName, String passportNumber) {
        if (passportNumber == null || passportNumber.trim().isEmpty()) {
            throw new RuntimeException("Passport number must not be null or empty."); // FIX: RuntimeException
        }
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new RuntimeException("First name must not be null or empty."); // FIX: RuntimeException
        }
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new RuntimeException("Last name must not be null or empty."); // FIX: RuntimeException
        }
    }

    public Applicant saveApplicant(Applicant applicant) {
        validateApplicant(applicant.getFirstName(), applicant.getLastName(), applicant.getPassportNumber());
        return applicantRepository.save(applicant);
    }

    public Applicant saveApplicant(String firstName, String lastName, String passportNumber, String nationality) {
        validateApplicant(firstName, lastName, passportNumber);
        Applicant applicant = new Applicant();
        applicant.setFirstName(firstName);
        applicant.setLastName(lastName);
        applicant.setPassportNumber(passportNumber);
        applicant.setNationality(nationality);
        return applicantRepository.save(applicant);
    }

    public AsylumSeeker saveAsylumSeeker(AsylumSeeker seeker) {
        validateApplicant(seeker.getFirstName(), seeker.getLastName(), seeker.getPassportNumber());
        return applicantRepository.save(seeker);
    }

    public Applicant flagCriminalRecord(Long applicantId) {
        Applicant applicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> new RuntimeException("Applicant not found with ID: " + applicantId));

        applicant.setCriminalRecord(true);
        applicantRepository.save(applicant);

        List<Interview> interviews = interviewRepository.findByApplicantId(applicantId);
        for (Interview interview : interviews) {
            if ("SCHEDULED".equals(interview.getStatus())) {
                interview.setStatus("CANCELLED");
                interviewRepository.save(interview);
            }
        }

        return applicant;
    }

    public List<Applicant> getAllApplicants() {
        return applicantRepository.findAll();
    }

    public Applicant getApplicantById(Long id) {
        return applicantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Applicant not found with ID: " + id));
    }

    public List<Applicant> getApplicantsByNationality(String nationality) {
        if (nationality == null || nationality.trim().isEmpty()) {
            throw new RuntimeException("Nationality search parameter must not be empty.");
        }
        return applicantRepository.findByNationality(nationality);
    }
}