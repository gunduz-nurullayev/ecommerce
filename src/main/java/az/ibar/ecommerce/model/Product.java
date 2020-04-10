package az.ibar.ecommerce.model;

import az.ibar.ecommerce.model.enums.PaymentTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class Product {

    private long id;
    private String name;
    private Category category;
    private String description;
    private BigDecimal price;
    private PaymentTypeEnum paymentType;
    private LocalDateTime addedDate;
}
