package az.ibar.ecommerce.repository;

import az.ibar.ecommerce.model.User;

public interface UserDao {

    boolean addUser(User user);

    boolean loginUser(User user);
}
