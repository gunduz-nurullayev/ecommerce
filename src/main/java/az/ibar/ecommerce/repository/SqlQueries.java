package az.ibar.ecommerce.repository;

public class SqlQueries {


    public static final String CHECK_EMAIL = "SELECT count(*) FROM customer where email=:email";

    public static final String ADD_USER = "insert into users(username, password, role_id) values(:username, :password, :role.getValue) ";

    public static final String ADD_CUSTOMER = "insert into customer(name, surname, customer_code, email, address, phone, merchant_type) " +
            "values(:name, :surname, :customerCode, :email, :address, :phone, :merchant.getValue);" ;

    public static final String CHECK_USER_LOGIN = "select count(*) from users where username = :username and password = :password " +
            "and role_id = :role.getValue and status=1";
}
