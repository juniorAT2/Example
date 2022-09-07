package it.accenture.mapstruct;

import it.accenture.dto.PersonDTO;import it.accenture.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "id", source = "id")
    PersonDTO fromPerson (Person person);
    @Mapping(target = "id", source = "id")
    Person toPerson(PersonDTO personDTO);
}
