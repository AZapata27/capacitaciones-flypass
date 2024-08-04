package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.repository.b.jdbc;

import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.entity.Post;
import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> findAll() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.queryForList(sql, User.class);
    }

    public User findById(Long id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, User.class);
    }

    public void save(User user) {
        String sql = "INSERT INTO users (username, email, created_at, created_by) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getUsername(), user.getEmail(), user.getCreatedAt(), user.getCreatedBy());
    }

    public void update(User user) {
        String sql = "UPDATE users SET username = ?, email = ? WHERE id = ?";
        jdbcTemplate.update(sql, user.getUsername(), user.getEmail(), user.getId());
    }

    public void deleteById(Long id) {
        String sql = "DELETE FROM users WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    private static class PostRowMapper implements RowMapper<Post> {
        @Override
        public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
            Post post = new Post();
            post.setId(rs.getLong("post_id"));
            post.setTitle(rs.getString("title"));

            User author = new User();
            author.setId(rs.getLong("user_id"));
            author.setUsername(rs.getString("username"));
            author.setEmail(rs.getString("email"));
            author.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
            author.setCreatedBy(rs.getString("created_by"));

            post.setAuthor(author);
            return post;
        }
    }

}


