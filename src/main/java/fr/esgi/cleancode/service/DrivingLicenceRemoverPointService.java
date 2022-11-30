package fr.esgi.cleancode.service;

import fr.esgi.cleancode.database.InMemoryDatabase;
import fr.esgi.cleancode.exception.ResourceNotFoundException;
import fr.esgi.cleancode.model.DrivingLicence;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class DrivingLicenceRemoverPointService {

    private final InMemoryDatabase database;

    private final DrivingLicenceFinderService drivingLicenceFinderService;

    public DrivingLicence removePoint(UUID drivingLicenceId, int nbPointToRemove) {
        var optionalDrivingLicence = findLicence(drivingLicenceId);
        var drivingLicence = checkLicence(optionalDrivingLicence);
        drivingLicence = removePointLicence(drivingLicence, nbPointToRemove);
        return saveLicence(drivingLicence);
    }

    private Optional<DrivingLicence> findLicence(UUID drivingLicenceId) {
        return drivingLicenceFinderService.findById(drivingLicenceId);
    }

    private DrivingLicence checkLicence(Optional<DrivingLicence> optionalDrivingLicence) {
        if (optionalDrivingLicence.isEmpty())
        {
            throw new ResourceNotFoundException("Driving Licence not found");
        }
        return optionalDrivingLicence.get();
    }

    private DrivingLicence removePointLicence(DrivingLicence drivingLicence, int nbPointToRemove) {
        return drivingLicence.removePoint(nbPointToRemove);
    }

    private DrivingLicence saveLicence(DrivingLicence drivingLicence) {
        return database.save(drivingLicence.getId(), drivingLicence);
    }
}
