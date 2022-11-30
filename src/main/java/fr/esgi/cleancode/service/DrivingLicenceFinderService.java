package fr.esgi.cleancode.service;

import fr.esgi.cleancode.database.InMemoryDatabase;
import fr.esgi.cleancode.model.DrivingLicence;
import fr.esgi.cleancode.model.SocialSecurityNumber;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class DrivingLicenceFinderService {

    private final InMemoryDatabase database;

    public Optional<DrivingLicence> findById(UUID drivingLicenceId) {
        return Optional.ofNullable(DrivingLicence.builder()
                .driverSocialSecurityNumber(SocialSecurityNumber.builder()
                        .number("test")
                        .build())
                .build());
    }
}
