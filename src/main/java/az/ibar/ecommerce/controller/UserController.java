package az.ibar.ecommerce.controller;

import az.ibar.ecommerce.model.Customer;
import az.ibar.ecommerce.model.User;
import az.ibar.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    public Map<String, Object> addCustomer(User user) {
        Map<String, Object> data = new HashMap<>();
        try {
            if (userService.loginUser(user)) {
                data.put("state", "correct");
            } else {
                data.put("state", "wrong");
            }
        } catch (Exception ex) {
            data.put("state", "error");
        } finally {
            return data;

        }
    }
}
