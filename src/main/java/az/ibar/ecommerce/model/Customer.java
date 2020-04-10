package az.ibar.ecommerce.model;

import az.ibar.ecommerce.model.enums.MerchantEnum;
import az.ibar.ecommerce.model.enums.StatusEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class Customer {
    private long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String customerCode;
    private LocalDateTime createdDate;
    private MerchantEnum merchant;
    private StatusEnum status;

}
