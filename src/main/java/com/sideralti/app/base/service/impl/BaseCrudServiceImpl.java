package com.sideralti.app.base.service.impl;

import com.sideralti.app.base.repository.BaseRepository;
import com.sideralti.app.base.service.BaseCrudService;
import com.sideralti.app.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class BaseCrudServiceImpl<T, ID> implements BaseCrudService<T, ID> {

    protected final BaseRepository<T, ID> repository;

    public BaseCrudServiceImpl(BaseRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public T save(T entity) {
        validateBeforeSave(entity);
        return repository.save(entity);
    }

    @Override
    public T update(ID id, T entity) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(getEntityName(), "id", id);
        }
        validateBeforeUpdate(id, entity);
        return repository.save(entity);
    }

    @Override
    public void delete(ID id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(getEntityName(), "id", id);
        }
        validateBeforeDelete(id);
        repository.deleteById(id);
    }

    @Override
    public T findById(ID id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(getEntityName(), "id", id));
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public boolean existsById(ID id) {
        return repository.existsById(id);
    }

    protected abstract String getEntityName();
    protected abstract void validateBeforeSave(T entity);
    protected abstract void validateBeforeUpdate(ID id, T entity);
    protected abstract void validateBeforeDelete(ID id);
}