package az.ibar.ecommerce.repository;

import az.ibar.ecommerce.model.Customer;

public interface CustomerDao {
    boolean checkCustomerEmail(String email);

    boolean addCustomer(Customer customer);
}
