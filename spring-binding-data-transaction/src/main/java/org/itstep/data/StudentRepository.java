package org.itstep.data;

import org.itstep.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.List;
import java.util.Objects;

@Repository
public class StudentRepository implements org.itstep.data.Repository<Student, Integer> {
    private RowMapper<Student> ROW_MAPPER = (rs, rowNum) -> new Student(rs.getInt("id"),
            rs.getString("first_name"),
            rs.getString("last_Name"),
            rs.getInt("age"),
            rs.getInt("groupId"));

    private JdbcTemplate jdbcTemplate;
    private DataSourceTransactionManager txManager;
    @Autowired
    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, rollbackFor = SQLException.class, noRollbackFor = FileNotFoundException.class)
    @Override
    public Integer save(Student data) {
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps =
                    con.prepareStatement("insert into students(first_name, last_name, age, `groupId`) values(?, ?, ?, ?)",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, data.getFirstName());
            ps.setString(2, data.getLastName());
            ps.setInt(3, data.getAge());
            ps.setInt(4, data.getGroupId());
            return ps;
        }, holder);
        return Objects.requireNonNull(holder.getKey()).intValue();
    }
    @Transactional(isolation = Isolation.REPEATABLE_READ, rollbackFor = SQLException.class, noRollbackFor = FileNotFoundException.class)
    @Override
    public void update(Student data) {
        jdbcTemplate.update("update `students` SET first_name= ?, last_name=?, age= ?,`groupId`=? where id = ?",
                preparedStatement -> {
                    preparedStatement.setString(1, data.getFirstName());
                    preparedStatement.setString(2, data.getLastName());
                    preparedStatement.setInt(3, data.getAge());
                    preparedStatement.setInt(4, data.getGroupId());
                    preparedStatement.setInt(5, data.getId());
                });

    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, rollbackFor = SQLException.class, noRollbackFor = FileNotFoundException.class)
    @Override
    public void delete(Student data) {

        jdbcTemplate.update("delete from students where id = ?", data.getId());
    }

    @Transactional(readOnly = true)
    @Override
    public List<Student> findAll() {
        return jdbcTemplate.query("select id, first_name, last_name, age, `groupId` from students",
                (rs, rowNum) -> new Student(rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getInt("age"),
                        rs.getInt("groupId")));
    }

    @Transactional(readOnly = true)
    @Override
    public Student find(Integer id) {
        return jdbcTemplate.queryForObject("select * from students where id = ?", new Object[]{id}, ROW_MAPPER);

    }
}
