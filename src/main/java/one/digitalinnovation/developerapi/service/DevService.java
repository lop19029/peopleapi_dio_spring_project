package one.digitalinnovation.developerapi.service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.developerapi.dto.mapper.DevMapper;
import one.digitalinnovation.developerapi.dto.request.DevDTO;
import one.digitalinnovation.developerapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.developerapi.entity.Developer;
import one.digitalinnovation.developerapi.exception.DeveloperNotFoundException;
import one.digitalinnovation.developerapi.repository.DevRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DevService {

    private DevRepository devRepository;

    private final DevMapper devMapper = DevMapper.INSTANCE;

    public MessageResponseDTO createPerson(DevDTO devDTO){
        Developer developerToSave = devMapper.toModel(devDTO) ;

        Developer savedDeveloper = devRepository.save(developerToSave);
        return createMessageResponse(savedDeveloper.getId(), "Created person with ID ");
    }

    public List<DevDTO> listAll() {
        List<Developer> allDevs = devRepository.findAll();

        return allDevs.stream().
                map(devMapper::toDTO)
                .collect(Collectors.toList());
    }

    public DevDTO findById(Long id) throws DeveloperNotFoundException {
        Developer developer = verifyIfExists(id);
        return devMapper.toDTO(developer);
    }

    public MessageResponseDTO updateById(Long id, DevDTO devDTO) throws DeveloperNotFoundException {
        verifyIfExists(id);
        Developer developerToUpdate = devMapper.toModel(devDTO) ;
        Developer updatedDeveloper = devRepository.save(developerToUpdate);
        return createMessageResponse(updatedDeveloper.getId(), "Updated person with ID ");

    }

    public void delete(Long id) throws DeveloperNotFoundException {
        verifyIfExists(id);
        devRepository.deleteById(id);
    }

    private Developer verifyIfExists(Long id) throws DeveloperNotFoundException {
        return devRepository.findById(id)
                .orElseThrow(() -> new DeveloperNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
