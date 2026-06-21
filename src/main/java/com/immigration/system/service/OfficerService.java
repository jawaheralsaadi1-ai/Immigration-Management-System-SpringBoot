package com.immigration.system.service;

import com.immigration.system.entities.BorderControlOfficer;
import com.immigration.system.entities.ImmigrationCenter;
import com.immigration.system.entities.ImmigrationOfficer;
import com.immigration.system.repository.CenterRepository;
import com.immigration.system.repository.OfficerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficerService {

    private final OfficerRepository officerRepository;
    private final CenterRepository centerRepository;

    public OfficerService(OfficerRepository officerRepository, CenterRepository centerRepository) {
        this.officerRepository = officerRepository;
        this.centerRepository = centerRepository;
    }

    private void validateOfficer(String firstName, String badgeNumber) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new RuntimeException("Officer first name is required."); // FIX: Standard RuntimeException
        }
        if (badgeNumber == null || badgeNumber.trim().isEmpty()) {
            throw new RuntimeException("Badge number is required."); // FIX: Standard RuntimeException
        }
    }

    // FIX: Accept and Return raw Entity directly
    public ImmigrationOfficer saveOfficer(ImmigrationOfficer officer, Long centerId) {
        validateOfficer(officer.getFirstName(), officer.getBadgeNumber());
        officer.setActive(true);

        if (centerId != null) {
            ImmigrationCenter center = centerRepository.findById(centerId)
                    .orElseThrow(() -> new RuntimeException("ImmigrationCenter not found with ID: " + centerId));
            officer.setCenter(center);
        }

        return officerRepository.save(officer);
    }

    // FIX: Accept and Return raw Entity directly
    public BorderControlOfficer saveBorderControlOfficer(BorderControlOfficer officer, Long centerId) {
        validateOfficer(officer.getFirstName(), officer.getBadgeNumber());
        officer.setActive(true);

        if (centerId != null) {
            ImmigrationCenter center = centerRepository.findById(centerId)
                    .orElseThrow(() -> new RuntimeException("ImmigrationCenter not found with ID: " + centerId));
            officer.setCenter(center);
        }

        return officerRepository.save(officer);
    }

    public ImmigrationOfficer getOfficerById(Long id) {
        return findOfficerOrThrow(id);
    }

    public List<ImmigrationOfficer> getAllOfficers() {
        return officerRepository.findAll();
    }

    // FIX: Business validation matching requirement rules explicitly
    public ImmigrationOfficer promoteOfficer(Long officerId, String newRank, int newClearanceLevel) {
        if (newClearanceLevel < 1 || newClearanceLevel > 5) {
            throw new RuntimeException("Clearance level must be between 1 and 5. Provided: " + newClearanceLevel); // FIX: RuntimeException
        }

        ImmigrationOfficer officer = findOfficerOrThrow(officerId);
        officer.setRank(newRank);
        officer.setClearanceLevel(newClearanceLevel);

        return officerRepository.save(officer);
    }

    public ImmigrationOfficer transferOfficer(Long officerId, Long newCenterId) {
        ImmigrationOfficer officer = findOfficerOrThrow(officerId);

        ImmigrationCenter center = centerRepository.findById(newCenterId)
                .orElseThrow(() -> new RuntimeException("ImmigrationCenter not found with ID: " + newCenterId));

        officer.setCenter(center);
        return officerRepository.save(officer);
    }

    // Overloaded Methods returning Entity Lists [cite: 59, 60]
    public List<ImmigrationOfficer> findOfficersByRank(String rank) {
        return officerRepository.findByRank(rank);
    }

    public ImmigrationOfficer findOfficerOrThrow(Long id) {
        return officerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ImmigrationOfficer not found with ID: " + id));
    }
}