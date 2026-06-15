package com.immigration.system.repository;

import com.immigration.system.entities.ImmigrationOfficer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfficerRepository extends JpaRepository {
// Add custom query method
    List<ImmigrationOfficer> findByRank(String rank);
}
