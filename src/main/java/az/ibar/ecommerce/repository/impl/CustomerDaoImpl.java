package az.ibar.ecommerce.repository.impl;

import az.ibar.ecommerce.model.Customer;
import az.ibar.ecommerce.repository.CustomerDao;
import az.ibar.ecommerce.repository.SqlQueries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class CustomerDaoImpl implements CustomerDao {

    Logger logger = LogManager.getLogger(CustomerDaoImpl.class);


    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public boolean checkCustomerEmail(String email) {
        return jdbcTemplate.queryForObject(SqlQueries.CHECK_EMAIL,
                new MapSqlParameterSource("email", email),
                Integer.class) > 0;
    }

    @Override
    public boolean addCustomer(Customer customer) {
        return jdbcTemplate.update(SqlQueries.ADD_CUSTOMER,
                new BeanPropertySqlParameterSource(customer)) > 0;
    }
}
