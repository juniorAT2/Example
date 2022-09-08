package it.accenture.repositories;

import it.accenture.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Long> {
    @Override
    <S extends Person> Iterable<S> saveAll(Iterable<S> entities);

    @Override
    Optional<Person> findById(Long id);

    @Override
    boolean existsById(Long id);

    @Override
    List<Person> findAll();

    List<Person> findAll(Sort sort);

    Page<Person> findAll(Pageable pageable);

    @Override
    List<Person> findAllById(Iterable<Long> longs);

    @Override
    long count();

    @Override
    void deleteById(Long id);

    @Override
    void delete(Person p);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends Person> entities);

    @Override
    void deleteAll();

    @Override
    Person save(Person p);

    Object[] getComponents(Person p);
}
