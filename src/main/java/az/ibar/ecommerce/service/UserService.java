package az.ibar.ecommerce.service;

import az.ibar.ecommerce.model.User;

public interface UserService {
    boolean addUser(User user);

    boolean loginUser(User user);
}
