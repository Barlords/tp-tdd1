package fr.esgi.cleancode.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class DrivingLicenceTest {
    @Test
    void should_be_remove_points()
    {
        var id = UUID.randomUUID();
        final var socialSecurityNumber = SocialSecurityNumber.builder().number("123456789123456").build();
        var given = DrivingLicence.builder().id(id).driverSocialSecurityNumber(socialSecurityNumber).build();
        var actual = given.removePoint(2);

        Assertions.assertEquals(given.getAvailablePoints()-2, actual.getAvailablePoints());
    }

    @Test
    void should_be_remove_points_to_zero()
    {
        var id = UUID.randomUUID();
        final var socialSecurityNumber = SocialSecurityNumber.builder().number("123456789123456").build();
        var given = DrivingLicence.builder().id(id).driverSocialSecurityNumber(socialSecurityNumber).build();
        var actual = given.removePoint(13);

        Assertions.assertEquals(0, actual.getAvailablePoints());
    }
}
