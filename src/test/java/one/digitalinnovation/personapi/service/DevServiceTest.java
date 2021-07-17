package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.dto.request.DevDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Developer;
import one.digitalinnovation.personapi.repository.DevRepository;
import one.digitalinnovation.personapi.utils.PersonUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static one.digitalinnovation.personapi.utils.PersonUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DevServiceTest {

    @Mock
    private DevRepository devRepository;

    @InjectMocks
    private DevService devService;

    @Test
    void testGivenPersonDTOThenReturnSavedMessage() {
        DevDTO devDTO = PersonUtils.createFakeDTO();

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
