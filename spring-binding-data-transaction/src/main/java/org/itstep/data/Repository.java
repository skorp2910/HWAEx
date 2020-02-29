package org.itstep.data;

import org.itstep.model.Group;
import org.itstep.model.Student;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public interface Repository<T, ID> {


    ID save(T data);

    void update(T data);

    void delete(T data);

    List<T> findAll();

    T find(ID id);

}
