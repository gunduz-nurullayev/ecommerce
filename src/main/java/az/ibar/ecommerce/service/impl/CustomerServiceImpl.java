package az.ibar.ecommerce.service.impl;

import az.ibar.ecommerce.configs.MailSubjectConfig;
import az.ibar.ecommerce.model.Customer;
import az.ibar.ecommerce.model.User;
import az.ibar.ecommerce.model.enums.RoleEnum;
import az.ibar.ecommerce.repository.CustomerDao;
import az.ibar.ecommerce.service.CustomerService;
import az.ibar.ecommerce.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    Logger logger = LogManager.getLogger(CustomerServiceImpl.class);


    @Autowired
    public CustomerDao customerDao;

    @Autowired
    public UserService userService;

    public boolean checkEmail(String email) {
        return customerDao.checkCustomerEmail(email);
    }

    @Override
    public boolean addCustomer(Customer customer) {
        boolean customerAdded = false;
        User user = new User();
        user.setPassword(customer.getPassword());
        user.setUsername(customer.getEmail());
        user.setRole(RoleEnum.CUSTOMER);

        if (userService.addUser(user)) {
            logger.info("User added!");
            customerAdded = customerDao.addCustomer(customer);

        }
        if (customerAdded) {
            if (MailService.sendMail(MailSubjectConfig.SUBJECT, customer.getName() + " " + customer.getSurname() + " " +
                    " siz ugurla qeydiyyatdan kecdiz! ", customer.getEmail())) {
                logger.info("Mail sent without any issue!");
            }
        }
        return customerAdded;
    }
}
