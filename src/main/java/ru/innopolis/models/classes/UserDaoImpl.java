package ru.innopolis.models.classes;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.innopolis.models.entities.User;
import ru.innopolis.models.interfaces.UserDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kuznetsov on 22/04/2017.
 */

@Repository
public class UserDaoImpl implements UserDao {

    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

    @Autowired
    private JdbcTemplate template;

    public List<User> getList() {

        return template.query("SELECT * FROM users ORDER BY id", new RowMapper<User>() {

            public User mapRow(ResultSet rs, int row) throws SQLException {
                User user = new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getBoolean(7)
                );
                return user;
            }
        });
    }

    public User getById(int id) {

        String sql = "SELECT * FROM users WHERE id = ?";

        return template.queryForObject(sql, BeanPropertyRowMapper.newInstance(User.class), id);
    }

    public int add(User user) {

        String sql = "INSERT INTO users (name, last_name, email, password, group_id, blocked) values (?, ?, ?, ?, ?, ?)";

        return template.update(sql, user.getName(), user.getLastName(), user.getEmail(), DigestUtils.md5Hex(user.getPassword()),
                user.getGroupId(), user.isBlocked());
    }

    public int update(User user) {

        String sql = "UPDATE users set name = ?, last_name = ?, email = ?, password = ?, group_id = ?, blocked = ? WHERE id = ?";

        return template.update(sql, user.getName(), user.getLastName(), user.getEmail(), DigestUtils.md5Hex(user.getPassword()),
                user.getGroupId(), user.isBlocked(), user.getId());
    }

    public int delete(int id) {

        String sql = "DELETE from users WHERE id = ?";

        return template.update(sql, id);
    }

    public Map<Integer, String> getAuthors() {

        String sql = "SELECT * FROM users WHERE group_id = 1 ORDER BY id";

        Map<Integer, String> authors = new HashMap<Integer, String>();

        List<Map<String, Object>> rows = template.queryForList(sql);

        for (Map row : rows) {
            authors.put((Integer) row.get("id"), row.get("name") + " " + row.get("last_name"));
        }

        return authors;
    }

    public int getCount() {

        String sql = "SELECT COUNT(*) FROM users";

        return template.queryForObject(sql, Integer.class);
    }
}