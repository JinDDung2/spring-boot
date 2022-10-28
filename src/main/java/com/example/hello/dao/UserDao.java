package com.example.hello.dao;

import com.example.hello.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class UserDao {

    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    public UserDao(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(User user) {
        String sql = "INSERT INTO users(id, name, password, email) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql);
    }

    public User findById(String id)  {
        String sql = "SELECT * FROM users ORDER BY users.id=?";
        return jdbcTemplate.queryForObject(sql, userRowMapper(), id);
    }

    private RowMapper<User> userRowMapper() {
        return ((rs, rowNum) -> {
            User user = new User(rs.getString("id"), rs.getString("name"),
                    rs.getString("password"), rs.getString("email"));
            return user;
        });
    }

    public int deleteAll() {
        String sql = "DELETE FROM users";
        return jdbcTemplate.update(sql);
    }

}
