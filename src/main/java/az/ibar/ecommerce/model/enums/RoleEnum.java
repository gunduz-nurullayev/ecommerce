package az.ibar.ecommerce.model.enums;

import java.util.Arrays;

public enum RoleEnum {
    ADMIN(1), CUSTOMER(2);

    private int value;

    RoleEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static RoleEnum fromValue(int value) {
        return Arrays.stream(values())
                .filter(t -> t.getValue() == value)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown role : " + value));
    }
}
