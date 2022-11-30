package fr.esgi.cleancode.service;

import fr.esgi.cleancode.database.InMemoryDatabase;
import fr.esgi.cleancode.model.DrivingLicence;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testng.annotations.Test;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DrivingLicenceRemoverPointServiceTest {

    @InjectMocks
    private DrivingLicenceRemoverPointService service;

    @Mock
    private InMemoryDatabase database;

    @Test
    void should_remove_point_of_driving_licence_and_save_it()
    {
        final var id = UUID.randomUUID();
        final var given = DrivingLicence.builder().id(id).build();
        final var modified = given.withAvailablePoints(10);
        when(database.findById(id)).thenReturn(Optional.of(given));
        when(database.save(id, modified)).thenReturn(modified);
        var actual = service.removePoint(id, 2);

        assertThat(given.getAvailablePoints()-2).isEqualTo(actual.getAvailablePoints());
    }

    @Test
    void should_not_found_licence()
    {
        final var id = UUID.randomUUID();
        when(database.findById(id)).thenReturn(Optional.empty());
        Assertions.assertThatException().isThrownBy(() -> service.removePoint(id, 2));

    }

}
