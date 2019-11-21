package org.itstep.repository;

import java.io.IOException;
import java.util.List;

public interface CrudRepository<T, ID> {
    ID save(T domain) throws IOException;

    T update(T domain) throws IOException;

    T findById(ID id) throws IOException;

    List<T> findAll() throws IOException;
}