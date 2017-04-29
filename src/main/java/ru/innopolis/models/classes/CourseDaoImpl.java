package ru.innopolis.models.classes;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import ru.innopolis.models.entities.Course;
import ru.innopolis.models.interfaces.CourseDao;

import java.util.List;

/**
 * Created by Kuznetsov on 22/04/2017.
 */

@Repository
public class CourseDaoImpl implements CourseDao {

    private static final Logger LOGGER = Logger.getLogger(CourseDaoImpl.class);

    public List<Course> getList() {
        return null;
    }

    public Course getById(int id) {
        return null;
    }

    public void add(Course course) {

    }

    public void update(Course course) {

    }

    public void delete(int id) {

    }
}