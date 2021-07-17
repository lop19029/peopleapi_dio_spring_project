package one.digitalinnovation.personapi.controller;


import lombok.AllArgsConstructor;
import one.digitalinnovation.personapi.dto.request.DevDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.exception.DeveloperNotFoundException;
import one.digitalinnovation.personapi.service.DevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DeveloperController {

    private DevService devService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createDeveloper(@RequestBody @Valid DevDTO devDTO) {
        return devService.createPerson(devDTO);
    }

    @GetMapping
    public List<DevDTO> listAllDevs() {
        return devService.listAll();
    }

    @GetMapping("/{id}")
    public DevDTO findDevById(@PathVariable Long id) throws DeveloperNotFoundException {
        return devService.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateDevById(@PathVariable Long id, @RequestBody @Valid DevDTO devDTO) throws DeveloperNotFoundException {
        return devService.updateById(id, devDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDevById(@PathVariable Long id) throws DeveloperNotFoundException {
        devService.delete(id);
    }
}
