package fr.esgi.cleancode.model;

import org.junit.jupiter.api.Test;

public class DrivingLicenceTest {
    @Test
    void should_be_remove_points()
    {
        final var socialSecurityNumber = SocialSecurityNumber.builder().number("123456789123456").build();
        var given = DrivingLicence.builder().driverSocialSecurityNumber(socialSecurityNumber).build();
        var actual = given.removePoint(2);

        Assertions.assertEquals(given.getAvailablePoints()-2, actual.getAvailablePoints());
    }
}
