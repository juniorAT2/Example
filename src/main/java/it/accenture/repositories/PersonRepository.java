package it.accenture.repositories;

import it.accenture.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class PersonRepository {

    private final JdbcTemplate template;
    private final String GET_ALL = "SELECT * FROM PERSON";
    private final String INSERT_PERSON = "INSERT INTO PERSON (NAME, SURNAME) VALUES (?, ?)";
    private final String UPDATE_PERSON = "UPDATE PERSON SET NAME = ?, SURNAME =? WHERE ID = ?";
    private final String DELETE_PERSON = "DELETE PERSON P WHERE P.ID = ?";
    private RowMapper<Person> rowMapper = (ResultSet rs, int rowNum) -> {
        Person person = new Person();
        person.setId(rs.getLong(1));
        person.setName(rs.getString(2));
        person.setSurname(rs.getString(3));
        return person;
    };
    @Autowired
    public PersonRepository(JdbcTemplate template) {
        this.template = template;
    }
    public List<Person> findAll () {
        return template.query(GET_ALL, rowMapper);
    }

    public boolean addPerson(Person person) {
        if (template.update(INSERT_PERSON, person.getName(), person.getSurname()) > 0) {
            return true;
        }
        return false;
    }

    public boolean updatePerson(Person person) {
        if (template.update(UPDATE_PERSON, person.getName(), person.getSurname(), person.getId()) > 0) {
            return true;
        }
        return false;
    }

    public boolean deletePerson(Long personId) {
        if (template.update(DELETE_PERSON, personId) > 0) {
            return true;
        }
        return false;
    }
}
