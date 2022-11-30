package fr.esgi.cleancode.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class SocialSecurityNumberTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"no", "no again", "166813521", "a12345678912345"})
    void should_be_not_valid(String ssn)
    {
        Assertions.assertThatException().isThrownBy(() -> SocialSecurityNumber.builder().number(ssn).build());
    }

    @Test
    void should_be_valid_social_security_number()
    {
        Assertions.assertThatNoException().isThrownBy(() -> SocialSecurityNumber.builder().number("123456789123456").build());
    }
}
