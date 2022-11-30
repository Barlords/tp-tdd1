package fr.esgi.cleancode.service;

import fr.esgi.cleancode.database.InMemoryDatabase;
import fr.esgi.cleancode.exception.InvalidDriverSocialSecurityNumberException;
import fr.esgi.cleancode.model.DrivingLicence;
import fr.esgi.cleancode.model.SocialSecurityNumber;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DrivingLicenceCreatorService {

    private final DrivingLicenceIdGenerationService drivingLicenceIdGenerationService;

    private final InMemoryDatabase database;

    public DrivingLicence create(String ssn) {
        verifySSSNValidity(ssn);
        var drivingLicence = buildDrivingLicence(ssn);
        return saveLicence(drivingLicence);
    }

    private void verifySSSNValidity(String ssn) {
        if (!SocialSecurityNumberValidatorService.isValidSSN(ssn)) {
            throw new InvalidDriverSocialSecurityNumberException("Social Security Number is invalid");
        }
    }

    private DrivingLicence buildDrivingLicence(String ssn) {
        return DrivingLicence.builder()
                .id(drivingLicenceIdGenerationService.generateNewDrivingLicenceId())
                .driverSocialSecurityNumber(SocialSecurityNumber.builder()
                        .number(ssn)
                        .build())
                .build();
    }

    private DrivingLicence saveLicence(DrivingLicence drivingLicence) {
        return database.save(drivingLicence.getId(), drivingLicence);
    }

}
