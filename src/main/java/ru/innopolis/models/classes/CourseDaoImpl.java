package ru.innopolis.models.classes;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.innopolis.models.entities.Course;
import ru.innopolis.models.entities.User;
import ru.innopolis.models.interfaces.CourseDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Kuznetsov on 22/04/2017.
 */

@Repository
public class CourseDaoImpl implements CourseDao {

    private static final Logger LOGGER = Logger.getLogger(CourseDaoImpl.class);

    @Autowired
    private JdbcTemplate template;

    public List<Course> getList() {
        return template.query("SELECT * FROM courses ORDER BY id", new RowMapper<Course>() {

            public Course mapRow(ResultSet rs, int row) throws SQLException {
                Course course = new Course(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                );
                return course;
            }
        });
    }

    public Course getById(int id) {

        String sql = "SELECT * FROM courses WHERE id = ?";

        return template.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<Course>(Course.class));
    }

    public int add(Course course) {

        String sql = "INSERT INTO courses (title, description, author_id) values (?, ?, ?)";

        return template.update(sql, course.getTitle(), course.getDescription(), course.getAuthorId());
    }

    public int update(Course course) {

        String sql = "UPDATE courses set title = ?, description = ?, author_id = ? WHERE id = ?";

        return template.update(sql, course.getTitle(), course.getDescription(), course.getAuthorId(), course.getId());
    }

    public int delete(int id) {

        String sql = "DELETE from courses WHERE id = ?";

        return template.update(sql, id);
    }
}