package az.ibar.ecommerce.model.enums;

import java.util.Arrays;

public enum StatusEnum {
    ACTIVE(1), DEACTIVE(0);

    private int value;

    StatusEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static StatusEnum fromValue(int value) {
        return Arrays.stream(values())
                .filter(t -> t.getValue() == value)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown status : " + value));
    }
}
