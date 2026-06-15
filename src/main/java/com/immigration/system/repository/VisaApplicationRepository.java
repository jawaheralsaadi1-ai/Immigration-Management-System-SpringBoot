package com.immigration.system.repository;

import com.immigration.system.entities.VisaApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public  interface VisaApplicationRepository extends JpaRepository<VisaApplication, Long> {
//Add custom query methods
    List<VisaApplication> findByApplicantId(Long applicantId);
    List<VisaApplication> findByStatus(String status);
}
