package az.ibar.ecommerce.model;

import az.ibar.ecommerce.model.enums.RoleEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
public class User {
    private int id;
    private String username;
    private String password;
    private LocalDateTime createdDate;
    private RoleEnum role;
}
