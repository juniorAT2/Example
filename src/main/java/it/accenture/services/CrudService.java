package it.accenture.services;

import it.accenture.exceptions.EntityNotFoundException;
import it.accenture.model.WithId;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public class CrudService<T extends WithId<K>, K, R extends CrudRepository<T, K>>  {
    protected final R repo;
    protected Class<?> entityClass;
    public static final String ERROR_NOT_FOUND = "Entity %s with id %d does not exist.";
    public CrudService(R repo, Class<?> entityClass){
        this.repo = repo;
        this.entityClass = entityClass;
    }
    public Iterable<T> getAll() {
        return repo.findAll();
    }
    public Optional<T> findById(K k) {
        return repo.findById(k);
    }
    public void deleteById(K k) throws EntityNotFoundException {
        if (exists(k)) {
            repo.deleteById(k);
        } else {
            throw new EntityNotFoundException(ERROR_NOT_FOUND, entityClass, (long) k);
        }
    }
    public T saveOrUpdate(T t) throws EntityNotFoundException {
        if (t.getId()!=null && !t.getId().equals(0) && !exists(t.getId())) {
            throw new EntityNotFoundException(ERROR_NOT_FOUND, entityClass, (long) t.getId());
        }
        return repo.save(t);
    }
    public boolean exists(K id) {
        return findById(id).isPresent();
    }
}