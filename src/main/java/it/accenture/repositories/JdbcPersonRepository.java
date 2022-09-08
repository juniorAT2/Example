package it.accenture.repositories;

import it.accenture.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
@Profile("jdbc")
public class JdbcPersonRepository implements PersonRepository {

    private final JdbcTemplate template;

    @Autowired
    public JdbcPersonRepository(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public <S extends Person> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Person> findById(Long id) {
        Person p = template.queryForObject("FROM PERSON P WHERE P.ID = :id", this::rowMapper, id);
        if (p == null)
            return Optional.empty();
        else
            return Optional.of(p);
    }
    private Person rowMapper(ResultSet rs, int rowNum) throws SQLException {

        return new Person(rs.getLong("ID"), rs.getString("NAME"), rs.getString("SURNAME"));
    }

    @Override
    public boolean existsById(Long id) {
        return findById(id).isPresent();
    }

    @Override
    public List<Person> findAll() {
        return template.query("SELECT * FROM PERSON", this::rowMapper);
    }

    @Override
    public List<Person> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Person> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Person> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long id) {
        template.update("DELETE FROM CLASSROOM WHERE ID = ?", id);
    }



    @Override
    public void delete(Person p) {
        deleteById(p.getId());
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        for (Long id: longs) deleteById(id);
    }

    @Override
    public void deleteAll(Iterable<? extends Person> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Person save(Person p) {
        if (existsById(p.getId())){  //update
            template.update("UPDATE PERSON (ID, NAME, SURNAME)" +
                    " VALUES (?, ?, ?)", getComponents(p));
        }
        else{   //save
            template.update("Insert INTO PERSON ((ID, NAME, SURNAME)" +
                    " VALUES (?, ?, ?)", getComponents(p));
        }
        return p;
    }

    @Override
    public Object[] getComponents(Person p){
        return new Object[]{ p.getId(), p.getName(), p.getSurname()};
    }
}
