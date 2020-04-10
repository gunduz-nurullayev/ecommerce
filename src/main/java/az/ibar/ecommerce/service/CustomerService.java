package az.ibar.ecommerce.service;

import az.ibar.ecommerce.model.Customer;

public interface CustomerService {


    boolean checkEmail(String email);

    boolean addCustomer(Customer customer);
}
