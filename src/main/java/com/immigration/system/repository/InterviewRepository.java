package com.immigration.system.repository;

import com.immigration.system.entities.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterviewRepository extends JpaRepository<Interview, Long> {

    //Add custom query methods
    List<Interview> findByOfficerIdAndInterviewDate(Long officerId, String date);
    List<Interview> findByApplicantId(Long applicantId);
}
