package ru.innopolis.models.interfaces;

import ru.innopolis.models.entities.Lesson;

import java.util.List;

/**
 * Created by Kuznetsov on 22/04/2017.
 */

public interface LessonDao {
    List<Lesson> getListByCourseId(int courseId);

    List<Lesson> getList();

    Lesson getById(int id);

    int add(Lesson lesson);

    int update(Lesson lesson);

    int delete(int id);

    int getCount();
}