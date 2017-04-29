package ru.innopolis.models.classes;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import ru.innopolis.models.entities.User;
import ru.innopolis.models.interfaces.UserDao;

import java.util.List;

/**
 * Created by Kuznetsov on 22/04/2017.
 */

@Repository
public class UserDaoImpl implements UserDao {

    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

    public List<User> getList() {
        return null;
    }

    public User getById(int id) {
        return null;
    }

    public void add(User student) {

    }

    public void update(User student) {

    }

    public void delete(int id) {

    }

    public User getByEmailAndPassword(String email, String password) {
        return null;
    }
}