package one.digitalinnovation.developerapi.service;

import one.digitalinnovation.developerapi.dto.request.DevDTO;
import one.digitalinnovation.developerapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.developerapi.entity.Developer;
import one.digitalinnovation.developerapi.repository.DevRepository;
import one.digitalinnovation.developerapi.utils.DeveloperUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static one.digitalinnovation.developerapi.utils.DeveloperUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DevServiceTest {

    @Mock
    private DevRepository devRepository;

    @InjectMocks
    private DevService devService;

    @Test
    void testGivenDevDtoThenReturnSavedMassage() {
        DevDTO devDTO = DeveloperUtils.createFakeDTO();

        Developer expectedSavedDeveloper = createFakeEntity();

        when(devRepository.save(any(Developer.class))).thenReturn(expectedSavedDeveloper);

        MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedDeveloper.getId());
        MessageResponseDTO successMessage = devService.createPerson(devDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO createExpectedMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + id)
                .build();
    }
}
