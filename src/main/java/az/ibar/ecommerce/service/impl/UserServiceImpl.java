package az.ibar.ecommerce.service.impl;

import az.ibar.ecommerce.model.User;
import az.ibar.ecommerce.model.enums.RoleEnum;
import az.ibar.ecommerce.repository.UserDao;
import az.ibar.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserDao userDao;

    @Autowired
    public NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public boolean loginUser(User user) {
        user.setRole(RoleEnum.CUSTOMER);
        return userDao.loginUser(user);
    }
}
