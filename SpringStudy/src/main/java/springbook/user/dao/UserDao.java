package springbook.user.dao;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import springbook.user.domain.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class UserDao {
    private JdbcTemplate jdbcTemplate;
    private RowMapper<User> userMapper = new RowMapper<User>() {
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getString("id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            return user;
        }
    };

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void add(final User user) {
        jdbcTemplate.update("INSERT INTO users(id, name, password) VALUES (?,?,?)",
                             user.getId(), user.getName(), user.getPassword());
    }

    public User get(String id) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id = ?", new Object[] {id}, userMapper);
    }

    public List<User> getAll() {
        return jdbcTemplate.query("SELECT * FROM users ORDER BY id", userMapper);
    }

    public void deleteAll() {
        jdbcTemplate.update("DELETE FROM users");
    }

    public int getCount() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM users", Integer.class);
    }
}
