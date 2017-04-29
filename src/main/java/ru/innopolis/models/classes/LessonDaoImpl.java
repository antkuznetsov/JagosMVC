package ru.innopolis.models.classes;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import ru.innopolis.models.entities.Lesson;
import ru.innopolis.models.interfaces.LessonDao;

import java.util.List;

/**
 * Created by Kuznetsov on 22/04/2017.
 */

@Repository
public class LessonDaoImpl implements LessonDao {

    private static final Logger LOGGER = Logger.getLogger(LessonDaoImpl.class);


    public List<Lesson> getListByCourseId(int courseId) {
        return null;
    }

    public List<Lesson> getList() {
        return null;
    }

    public Lesson getById(int id) {
        return null;
    }

    public void add(Lesson lesson) {

    }

    public void update(Lesson lesson) {

    }

    public void delete(int id) {

    }
}