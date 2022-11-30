package fr.esgi.cleancode.service;

import fr.esgi.cleancode.model.SocialSecurityNumber;
import fr.esgi.cleancode.service.SocialSecurityNumberValidatorService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class SocialSecurityNumberValidatorServiceTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"no", "no again", "166813521", "a12345678912345"})
    void should_be_not_valid(String ssn)
    {
         var result = SocialSecurityNumberValidatorService.isValidSSN(ssn);
         Assertions.assertThat(result).isEqualTo(false);
    }

    @Test
    void should_be_valid_social_security_number()
    {
        var result = SocialSecurityNumberValidatorService.isValidSSN("123456789098765");
        Assertions.assertThat(result).isEqualTo(true);
    }
}
