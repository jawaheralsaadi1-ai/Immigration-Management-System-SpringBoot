package com.immigration.system.repository;

import com.immigration.system.entities.VisaApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface VisaApplicationRepository extends JpaRepository<VisaApplication, Long> {
}
