package az.ibar.ecommerce.model.enums;

import java.util.Arrays;

public enum PaymentTypeEnum {

    CASH(1), POST(2), ONLINE(3), CARD2CARD(4);

    private int value;

    PaymentTypeEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static PaymentTypeEnum fromValue(int value) {
        return Arrays.stream(values())
                .filter(t -> t.getValue() == value)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown merchant : " + value));
    }
}
