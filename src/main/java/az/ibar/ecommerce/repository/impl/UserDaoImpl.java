package az.ibar.ecommerce.repository.impl;

import az.ibar.ecommerce.model.User;
import az.ibar.ecommerce.repository.SqlQueries;
import az.ibar.ecommerce.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    public NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public boolean addUser(User user) {
        return jdbcTemplate.update(SqlQueries.ADD_USER, new BeanPropertySqlParameterSource(user)) > 0;
    }

    @Override
    public boolean loginUser(User user) {
        return jdbcTemplate.queryForObject(SqlQueries.CHECK_USER_LOGIN,
                new BeanPropertySqlParameterSource(user), Integer.class) > 0;
    }
}
