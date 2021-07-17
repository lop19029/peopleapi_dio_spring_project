package one.digitalinnovation.personapi.dto.mapper;

import one.digitalinnovation.personapi.dto.request.DevDTO;
import one.digitalinnovation.personapi.entity.Developer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DevMapper {

    DevMapper INSTANCE = Mappers.getMapper(DevMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Developer toModel(DevDTO dto);

    DevDTO toDTO(Developer dto);
}
