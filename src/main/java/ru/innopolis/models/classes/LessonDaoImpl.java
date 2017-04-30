package ru.innopolis.models.classes;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.innopolis.models.entities.Course;
import ru.innopolis.models.entities.Lesson;
import ru.innopolis.models.interfaces.LessonDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Kuznetsov on 22/04/2017.
 */

@Repository
public class LessonDaoImpl implements LessonDao {

    private static final Logger LOGGER = Logger.getLogger(LessonDaoImpl.class);

    @Autowired
    private JdbcTemplate template;

    public List<Lesson> getListByCourseId(int courseId) {

        String sql = "SELECT * FROM lessons WHERE course_id = " + courseId + " ORDER BY id";

        return template.query(sql, new RowMapper<Lesson>() {

            public Lesson mapRow(ResultSet rs, int row) throws SQLException {
                Lesson lesson = new Lesson(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                );
                return lesson;
            }
        });
    }

    public List<Lesson> getList() {

        return template.query("SELECT * FROM lessons ORDER BY id", new RowMapper<Lesson>() {

            public Lesson mapRow(ResultSet rs, int row) throws SQLException {
                Lesson lesson = new Lesson(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                );
                return lesson;
            }
        });
    }

    public Lesson getById(int id) {

        String sql = "SELECT * FROM lessons WHERE id = ?";

        return template.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<Lesson>(Lesson.class));

    }

    public int add(Lesson lesson) {

        String sql = "INSERT INTO lessons (title, content, course_id) values (?, ?, ?)";

        return template.update(sql, lesson.getTitle(), lesson.getContent(), lesson.getCourseId());
    }

    public int update(Lesson lesson) {

        String sql = "UPDATE lessons set title = ?, content = ?, course_id = ? WHERE id = ?";

        return template.update(sql, lesson.getTitle(), lesson.getContent(), lesson.getCourseId(), lesson.getId());
    }

    public int delete(int id) {

        String sql = "DELETE from lessons WHERE id = ?";

        return template.update(sql, id);
    }
}