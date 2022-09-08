package it.accenture.mapstruct;

import it.accenture.dtos.PersonDTO;
import it.accenture.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
    @Mapping(target = "id", source = "id")
    PersonDTO fromPerson(Person c);
    @Mapping(target = "id", source = "id")
    Person toPerson(PersonDTO cDTO);
}
