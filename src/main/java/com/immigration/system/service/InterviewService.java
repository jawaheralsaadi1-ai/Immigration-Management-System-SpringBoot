package com.immigration.system.service;

import com.immigration.system.dto.requests.InterviewRequest;
import com.immigration.system.dto.responses.InterviewResponse;
import com.immigration.system.entities.Applicant;
import com.immigration.system.entities.ImmigrationOfficer;
import com.immigration.system.entities.Interview;
import com.immigration.system.dto.exceptions.BusinessRuleException;
import com.immigration.system.dto.exceptions.ResourceNotFoundException;
import com.immigration.system.dto.exceptions.ValidationException;
import com.immigration.system.repository.ApplicantRepository;
import com.immigration.system.repository.InterviewRepository;
import com.immigration.system.repository.OfficerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InterviewService {

    private final InterviewRepository interviewRepository;
    private final ApplicantRepository applicantRepository;
    private final OfficerRepository officerRepository;

    public InterviewService(InterviewRepository interviewRepository,
                            ApplicantRepository applicantRepository,
                            OfficerRepository officerRepository) {
        this.interviewRepository = interviewRepository;
        this.applicantRepository = applicantRepository;
        this.officerRepository = officerRepository;
    }

    //  Schedule Interview using DTOs and custom exceptions
    public InterviewResponse scheduleInterview(InterviewRequest request) {
        // (HTTP 400)
        if (request.getInterviewDate() == null || request.getInterviewDate().trim().isEmpty()) {
            throw new ValidationException("Interview date is required.", "interviewDate", request.getInterviewDate());
        }

        // HTTP 404)
        Applicant applicant = applicantRepository.findById(request.getApplicantId())
                .orElseThrow(() -> new ResourceNotFoundException("Applicant", request.getApplicantId()));

        ImmigrationOfficer officer = officerRepository.findById(request.getOfficerId())
                .orElseThrow(() -> new ResourceNotFoundException("ImmigrationOfficer", request.getOfficerId()));

        // (HTTP 422)
        List<Interview> existingInterviews = interviewRepository.findByOfficerIdAndInterviewDate(
                request.getOfficerId(), request.getInterviewDate());
        if (!existingInterviews.isEmpty()) {
            throw new BusinessRuleException("Officer is double-booked!", "OFFICER_DOUBLE_BOOKED");
        }

        //  Save entity
        Interview interview = new Interview();
        interview.setApplicant(applicant);
        interview.setOfficer(officer);
        interview.setInterviewDate(request.getInterviewDate());
        interview.setStatus("SCHEDULED");
        interview.setPurpose(request.getPurpose());

        Interview saved = interviewRepository.save(interview);
        return toResponse(saved);
    }

    // Complete Interview
    public InterviewResponse completeInterview(Long interviewId) {
        Interview interview = interviewRepository.findById(interviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Interview", interviewId));

        interview.setStatus("COMPLETED");
        Interview saved = interviewRepository.save(interview);
        return toResponse(saved);
    }

    //  Cancel Interview
    public InterviewResponse cancelInterview(Long interviewId) {
        Interview interview = interviewRepository.findById(interviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Interview", interviewId));

        interview.setStatus("CANCELLED");
        Interview saved = interviewRepository.save(interview);
        return toResponse(saved);
    }

    //  Fetch officer schedule endpoints
    public List<InterviewResponse> getInterviewsByOfficerAndDate(Long officerId, String date) {
        return interviewRepository.findByOfficerIdAndInterviewDate(officerId, date)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    // DTO Translation Helper Mapping Function
    private InterviewResponse toResponse(Interview interview) {
        String applicantName = interview.getApplicant().getFirstName() + " " + interview.getApplicant().getLastName();
        String officerName = interview.getOfficer().getFirstName() + " " + interview.getOfficer().getLastName();

        return new InterviewResponse(
                interview.getId(),
                interview.getApplicant().getId(),
                applicantName,
                interview.getOfficer().getId(),
                officerName,
                interview.getInterviewDate(),
                interview.getStatus(),
                interview.getPurpose()
        );
    }
}