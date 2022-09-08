package it.accenture.services.implementations;

import it.accenture.exceptions.EntityNotFoundException;
import it.accenture.model.abstractions.WithId;
import it.accenture.services.abstractions.AbstractCrudService;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public class CrudService<T extends WithId<K>, K, R extends CrudRepository<T, K>> implements AbstractCrudService<T, K> {
    protected final R repo;
    protected Class<?> entityClass;
    public static final String ERROR_NOT_FOUND = "L'entità %s con id %d non esiste";
    public CrudService(R repo, Class<?> entityClass){
        this.repo = repo;
        this.entityClass = entityClass;
    }

    @Override
    public Iterable<T> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<T> findById(K k) {
        return repo.findById(k);
    }

    @Override
    public void deleteById(K k) throws EntityNotFoundException {
        if (exists(k)) {
            repo.deleteById(k);
        } else {
            throw new EntityNotFoundException(ERROR_NOT_FOUND, entityClass, (long) k);
        }
    }

    @Override
    public T saveOrUpdate(T t) throws EntityNotFoundException {
        if (t.getId()!=null && !t.getId().equals(0) && !exists(t.getId())) {
            throw new EntityNotFoundException(ERROR_NOT_FOUND, entityClass, (long) t.getId());
        }
        return repo.save(t);
    }

    @Override
    public boolean exists(K id) {
        return findById(id).isPresent();
    }

}