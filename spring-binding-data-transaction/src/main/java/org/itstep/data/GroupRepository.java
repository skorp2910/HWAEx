package org.itstep.data;

import com.mysql.cj.result.Row;
import org.itstep.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

@Repository
public class GroupRepository implements org.itstep.data.Repository<Group, Integer> {

    private RowMapper<Group> GROUP_ROW_MAPPER = (rs, rowNum) -> new Group(rs.getInt("id"),
            rs.getString("name")
    );

    private JdbcTemplate jdbcTemplate1;

    @Autowired
    public GroupRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate1 = jdbcTemplate;
    }

    @Override
    public Integer save(Group data) {
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate1.update(con -> {
            PreparedStatement ps =
                    con.prepareStatement("insert into `groups`( name) values(?)",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, data.getName());
            return ps;
        }, holder);
        return Objects.requireNonNull(holder.getKey()).intValue();
    }

    @Override
    public void update(Group data) {
        jdbcTemplate1.update("update `groups` set name = ? where id = ?",
                preparedStatement -> {
                    preparedStatement.setString(1, data.getName());
                    preparedStatement.setInt(2, data.getId());
                });
    }

    @Override
    public void delete(Group data) {
        jdbcTemplate1.update("delete from `groups` where id = ?", data.getId());
    }

    @Override
    public List<Group> findAll() {

        return jdbcTemplate1.query("select id,name from `groups`",
                (rs, rowNum) -> new Group(rs.getInt("id"),
                        rs.getString("name")));
    }

    @Override
    public Group find(Integer id) {

        return jdbcTemplate1.queryForObject("select * from `groups` where id = ?", new Object[]{id}, GROUP_ROW_MAPPER);
    }
}
