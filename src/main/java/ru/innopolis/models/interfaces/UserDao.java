package ru.innopolis.models.interfaces;

import ru.innopolis.models.entities.User;

import java.util.List;

/**
 * Created by Kuznetsov on 22/04/2017.
 */

public interface UserDao {
    List<User> getList();

    User getById(int id);

    int add(User student);

    int update(User student);

    int delete(int id);

    User getByEmailAndPassword(String email, String password);
}