package com.immigration.system.repository;

import com.immigration.system.entities.ImmigrationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CenterRepository extends JpaRepository<ImmigrationCenter, Long> {}
