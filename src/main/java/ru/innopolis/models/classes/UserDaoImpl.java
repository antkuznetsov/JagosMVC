package ru.innopolis.models.classes;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.innopolis.models.entities.User;
import ru.innopolis.models.interfaces.UserDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Kuznetsov on 22/04/2017.
 */

@Repository
public class UserDaoImpl implements UserDao {

    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

    @Autowired
    private JdbcTemplate template;

    public List<User> getList() {

        LOGGER.info("Вошли в гетлист");

        return template.query("SELECT * FROM users", new RowMapper<User>() {

            public User mapRow(ResultSet rs, int row) throws SQLException {
                LOGGER.info("Возвращаем пользователя");
                User user = new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getBoolean(7)
                );
                LOGGER.info(user);
                return user;
            }
        });
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