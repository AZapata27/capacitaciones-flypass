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
public class PostRepository {

    private final JdbcTemplate jdbcTemplate;

    public PostRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Post> findAll() {
        String sql = "SELECT * FROM posts";
        return jdbcTemplate.queryForList(sql, Post.class);
    }

    public Post findById(Long id) {
        String sql = "SELECT * FROM posts WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, Post.class);
    }

    public void save(Post post) {
        String sql = "INSERT INTO posts (title, user_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, post.getTitle(), post.getAuthor().getId());
    }

    public void update(Post post) {
        String sql = "UPDATE posts SET title = ?, user_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, post.getTitle(), post.getAuthor().getId(), post.getId());
    }

    public void deleteById(Long id) {
        String sql = "DELETE FROM posts WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }




    public List<Post> findAllWithUser() {
        String sql = "SELECT p.id AS post_id, p.title, u.id AS user_id, u.username, u.email, u.created_at, u.created_by " +
                "FROM posts p INNER JOIN users u ON p.user_id = u.id";
        return jdbcTemplate.query(sql, new PostRowMapper());
    }

    public Post findByIdWithUser(Long id) {
        String sql = "SELECT p.id AS post_id, p.title, u.id AS user_id, u.username, u.email, u.created_at, u.created_by " +
                "FROM posts p INNER JOIN users u ON p.user_id = u.id WHERE p.id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new PostRowMapper());
    }

    private static class PostRowMapper implements RowMapper<Post> {
        @Override
        public Post mapRow(ResultSet rs, int rowNum) throws SQLException {

            Post post = new Post();
            post.setId(rs.getLong("id"));
            post.setTitle(rs.getString("title"));


            User author = new User();
            author.setId(rs.getLong("user_id"));
            post.setAuthor(author);
            return post;
        }
    }
}
