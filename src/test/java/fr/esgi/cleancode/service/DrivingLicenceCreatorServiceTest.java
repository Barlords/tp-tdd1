package fr.esgi.cleancode.service;

import fr.esgi.cleancode.database.InMemoryDatabase;
import fr.esgi.cleancode.model.DrivingLicence;
import fr.esgi.cleancode.model.SocialSecurityNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DrivingLicenceCreatorServiceTest {

    @InjectMocks
    private DrivingLicenceCreatorService service;

    @Mock
    private InMemoryDatabase database;

    @Test
    void should_create_and_save_driving_licence_in_database()
    {
        var given = DrivingLicence.builder().driverSocialSecurityNumber(SocialSecurityNumber.builder().number("123456789123456").build()).build();
        when(database.save(given.getId(), given)).thenReturn(given);
        var actual = service.create("123456789123456");

        assertThat(actual).isEqualTo(given);
    }

    @Test
    void should_not_create()
    {
        Assertions.assertThatException().isThrownBy(() -> service.create("123456"));
    }

}
