package org.itstep.data;

import org.itstep.model.Student;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public interface Repository<T, ID> {
    RowMapper<Student> ROW_MAPPER = (rs, rowNum) -> new Student(rs.getInt("id"),
            rs.getString("first_name"),
            rs.getString("last_Name"),
            rs.getInt("age"),
            rs.getString("group"));

    ID save(T data);

    void update(T data);

    void delete(T data);

    List<T> findAll();

    T find(ID id);

}
