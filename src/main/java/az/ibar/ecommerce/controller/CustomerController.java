package az.ibar.ecommerce.controller;

import az.ibar.ecommerce.model.Customer;
import az.ibar.ecommerce.service.CustomerService;
import az.ibar.ecommerce.service.impl.CustomerServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class CustomerController {

    Logger logger = LogManager.getLogger(CustomerController.class);


    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/add/customer", method = RequestMethod.POST, produces = "application/json")
    @Transactional
    public Map<String, Object> addCustomer(Customer customer) {

        Map<String, Object> data = new HashMap<>();

        Date date = Calendar.getInstance().getTime();
        DateFormat df = new SimpleDateFormat("ssmmHH");
        Random r = new Random();
        customer.setCustomerCode("DX" + df.format(date) + r.nextInt(99));
        try {
            if (customer.getPassword().length() < 6) {
                data.put("state", "shortPassword");
                return data;
            }
            if (customerService.checkEmail(customer.getEmail())) {
                logger.info("Email used already!");
                data.put("state", "usedEmail");
                return data;
            } else {
                if (customerService.addCustomer(customer)) {
                    data.put("state", "added");
                }
            }
        } catch (Exception e) {
            data.put("state", "error");
            e.printStackTrace();
        } finally {
            return data;
        }
    }


}
