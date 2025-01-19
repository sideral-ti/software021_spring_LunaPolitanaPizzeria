package com.sideralti.app.base.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseCrudService<T, ID> {
    T save(T entity);
    T update(ID id, T entity);
    void delete(ID id);
    T findById(ID id);
    Page<T> findAll(Pageable pageable);
    boolean existsById(ID id);
}