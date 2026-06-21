package com.immigration.system.repository;

import com.immigration.system.entities.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
    //Add custom query methods
    List<Applicant> findByNationality(String nationality);
}
