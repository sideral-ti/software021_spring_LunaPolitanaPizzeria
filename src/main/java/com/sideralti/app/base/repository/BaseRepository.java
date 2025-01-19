package com.sideralti.app.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

@NoRepositoryBean
public interface BaseRepository<T, ID> extends JpaRepository<T, ID> {
    @Query("SELECT CASE WHEN COUNT(e) > 0 THEN true ELSE false END FROM #{#entityName} e WHERE e.id = :id")
    boolean existsById(@Param("id") ID id);
}