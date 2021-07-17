package one.digitalinnovation.developerapi.dto.mapper;

import one.digitalinnovation.developerapi.dto.request.DevDTO;
import one.digitalinnovation.developerapi.dto.request.PhoneDTO;
import one.digitalinnovation.developerapi.entity.Developer;
import one.digitalinnovation.developerapi.entity.Phone;
import one.digitalinnovation.developerapi.utils.DeveloperUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DevMapperTest {

    private DevMapper devMapper = DevMapper.INSTANCE;

    @Test
    void testGivenDevDTOThenReturnDevEntity() {
        DevDTO devDTO = DeveloperUtils.createFakeDTO();
        Developer developer = devMapper.toModel(devDTO);

        assertEquals(devDTO.getFirstName(), developer.getFirstName());
        assertEquals(devDTO.getLastName(), developer.getLastName());
        assertEquals(devDTO.getCpf(), developer.getCpf());

        Phone phone = developer.getPhones().get(0);
        PhoneDTO phoneDTO = devDTO.getPhones().get(0);

        assertEquals(phoneDTO.getType(), phone.getType());
        assertEquals(phoneDTO.getNumber(), phone.getNumber());
    }

    @Test
    void testGivenDevEntityThenReturnDevDTO() {
        Developer developer = DeveloperUtils.createFakeEntity();
        DevDTO devDTO = devMapper.toDTO(developer);

        assertEquals(developer.getFirstName(), devDTO.getFirstName());
        assertEquals(developer.getLastName(), devDTO.getLastName());
        assertEquals(developer.getCpf(), devDTO.getCpf());

        Phone phone = developer.getPhones().get(0);
        PhoneDTO phoneDTO = devDTO.getPhones().get(0);

        assertEquals(phone.getType(), phoneDTO.getType());
        assertEquals(phone.getNumber(), phoneDTO.getNumber());
    }

}
