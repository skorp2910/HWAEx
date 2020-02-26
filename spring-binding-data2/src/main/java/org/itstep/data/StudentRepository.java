package org.itstep.data;

import org.itstep.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;
import java.util.Objects;

@Repository
public class StudentRepository implements org.itstep.data.Repository<Student, Integer> {


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Integer save(Student data) {
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps =
                    con.prepareStatement("insert into students(first_name, last_name, age, `group`) values(?, ?, ?, ?)",
                                         Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, data.getFirstName());
            ps.setString(2, data.getLastName());
            ps.setInt(3, data.getAge());
            ps.setString(4, data.getGroup());
            return ps;
        }, holder);
        return Objects.requireNonNull(holder.getKey()).intValue();
    }

    @Override
    public void update(Student data) {
       jdbcTemplate.update("update `students` SET first_name= ?, last_name=?, age= ?,`group`=? where id = ?",
               preparedStatement -> {
                            preparedStatement.setString(1,data.getFirstName());
                            preparedStatement.setString(2,data.getLastName());
                            preparedStatement.setInt(3,data.getAge());
                            preparedStatement.setString(4,data.getGroup());
                            preparedStatement.setInt(5,data.getId());
               });
    }

    @Override
    public void delete(Student data) {

        jdbcTemplate.update("delete from students where id = ?", data.getId());
    }

    @Override
    public List<Student> findAll() {
        return jdbcTemplate.query("select id, first_name, last_name, age, `group` from students",
                (rs, rowNum) -> new Student(rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getInt("age"),
                        rs.getString("group")));
    }

    @Override
    public Student find(Integer id) {

        return jdbcTemplate.queryForObject("select * from students where id = ?",new Object[]{id},ROW_MAPPER);
    }
}
