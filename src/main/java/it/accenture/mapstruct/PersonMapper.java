package it.accenture.mapstruct;

import it.accenture.dto.PersonDTO;import it.accenture.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "id", source = "id")
    PersonDTO fromPerson (Person person);
    @Mapping(target = "id", source = "id")
    Person toPerson(PersonDTO personDTO);
    List<PersonDTO> fromPerson(Iterable<Person> all);
    PersonDTO fromPerson(Optional<Person> one);
}
