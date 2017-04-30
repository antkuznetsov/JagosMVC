package ru.innopolis.models.interfaces;

import ru.innopolis.models.entities.Course;

import java.util.List;

/**
 * Created by Kuznetsov on 22/04/2017.
 */

public interface CourseDao {
    List<Course> getList();

    Course getById(int id);

    int add(Course course);

    int update(Course course);

    int delete(int id);
}