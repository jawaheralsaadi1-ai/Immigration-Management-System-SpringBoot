package com.immigration.system.service;

import com.immigration.system.dto.requests.VisaApplicationRequest;
import com.immigration.system.dto.responses.VisaApplicationResponse;
import com.immigration.system.entities.Applicant;
import com.immigration.system.entities.ImmigrationOfficer;
import com.immigration.system.entities.VisaApplication;
import com.immigration.system.dto.exceptions.BusinessRuleException;
import com.immigration.system.dto.exceptions.ResourceNotFoundException;
import com.immigration.system.dto.exceptions.ValidationException;
import com.immigration.system.repository.ApplicantRepository;
import com.immigration.system.repository.OfficerRepository;
import com.immigration.system.repository.VisaApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisaApplicationService {

    private final VisaApplicationRepository visaApplicationRepository;
    private final ApplicantRepository applicantRepository;
    private final OfficerRepository officerRepository;

    public VisaApplicationService(VisaApplicationRepository visaApplicationRepository,
                                  ApplicantRepository applicantRepository,
                                  OfficerRepository officerRepository) {
        this.visaApplicationRepository = visaApplicationRepository;
        this.applicantRepository = applicantRepository;
        this.officerRepository = officerRepository;
    }

    // Submit Visa Application
    public VisaApplicationResponse submitApplication(VisaApplicationRequest request) {
        if (request.getVisaType() == null || request.getVisaType().trim().isEmpty()) {
            throw new ValidationException("Visa type is required.", "visaType", request.getVisaType());
        }

        Applicant applicant = applicantRepository.findById(request.getApplicantId())
                .orElseThrow(() -> new ResourceNotFoundException("Applicant", request.getApplicantId()));

        VisaApplication application = new VisaApplication();
        application.setApplicant(applicant);
        application.setVisaType(request.getVisaType());

        // Business Logic Validation: Criminal record flag auto-rejection
        if (applicant.isCriminalRecord()) {
            application.setStatus("REJECTED");
            application.setOfficerNotes("Auto-rejected due to criminal flag.");
        } else {
            application.setStatus("PENDING");
        }

        VisaApplication saved = visaApplicationRepository.save(application);
        return toResponse(saved);
    }

    //  Assign Handling Officer with clearance enforcement checks
    public VisaApplicationResponse assignOfficer(Long visaId, Long officerId) {
        VisaApplication application = visaApplicationRepository.findById(visaId)
                .orElseThrow(() -> new ResourceNotFoundException("VisaApplication", visaId));

        ImmigrationOfficer officer = officerRepository.findById(officerId)
                .orElseThrow(() -> new ResourceNotFoundException("ImmigrationOfficer", officerId));

        // Business Rule Verification
        if ("Asylum".equalsIgnoreCase(application.getVisaType())) {
            if (officer.getClearanceLevel() < 4 || officer.getClearanceLevel() > 5) {
                throw new BusinessRuleException(
                        "Officer lacks high clearance required for Asylum processing. Level provided: " + officer.getClearanceLevel(),
                        "INSUFFICIENT_OFFICER_CLEARANCE"
                );
            }
        }

        application.setHandlingOfficer(officer);
        VisaApplication saved = visaApplicationRepository.save(application);
        return toResponse(saved);
    }

    // Finalize and Process Visa status
    public VisaApplicationResponse processVisa(Long visaId, String newStatus, String notes) {
        VisaApplication application = visaApplicationRepository.findById(visaId)
                .orElseThrow(() -> new ResourceNotFoundException("VisaApplication", visaId));

        if (!"APPROVED".equals(newStatus) && !"REJECTED".equals(newStatus)) {
            throw new ValidationException("Invalid status provided. Must be APPROVED or REJECTED.", "status", newStatus);
        }

        application.setStatus(newStatus);
        application.setOfficerNotes(notes);

        VisaApplication saved = visaApplicationRepository.save(application);
        return toResponse(saved);
    }

    // Endpoints
    public List<VisaApplicationResponse> getVisasByApplicant(Long applicantId) {
        return visaApplicationRepository.findByApplicantId(applicantId)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public List<VisaApplicationResponse> getVisasByStatus(String status) {
        return visaApplicationRepository.findByStatus(status)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    // Entity to Response DTO Translator
    private VisaApplicationResponse toResponse(VisaApplication application) {
        String applicantName = application.getApplicant().getFirstName() + " " + application.getApplicant().getLastName();

        Long officerId = null;
        String officerName = null;
        if (application.getHandlingOfficer() != null) {
            officerId = application.getHandlingOfficer().getId();
            officerName = application.getHandlingOfficer().getFirstName() + " " + application.getHandlingOfficer().getLastName();
        }

        return new VisaApplicationResponse(
                application.getId(),
                application.getApplicant().getId(),
                applicantName,
                officerId,
                officerName,
                application.getVisaType(),
                application.getStatus(),
                application.getOfficerNotes()
        );
    }
}