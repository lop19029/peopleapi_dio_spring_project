package one.digitalinnovation.personapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personapi.entity.Technology;
import one.digitalinnovation.personapi.enums.ExpertiseArea;
import one.digitalinnovation.personapi.enums.PhoneType;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DevDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String lastName;

    @NotEmpty
    @CPF
    private String cpf;

    @NotNull
    private String birthDate;

    @Enumerated(EnumType.STRING)
    private ExpertiseArea expertiseArea;

    @Valid
    @NotEmpty
    private List<PhoneDTO> phones;

    @Valid
    @NotEmpty
    private List<Technology> technologies;
}
