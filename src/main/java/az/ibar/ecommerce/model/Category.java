package az.ibar.ecommerce.model;

import az.ibar.ecommerce.model.enums.StatusEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Category {
    private long id;
    private String name;
    private StatusEnum status;

}
