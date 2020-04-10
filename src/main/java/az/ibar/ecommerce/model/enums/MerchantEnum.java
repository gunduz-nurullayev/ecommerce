package az.ibar.ecommerce.model.enums;

import java.util.Arrays;

public enum MerchantEnum {
    MASTER(1),VISA(2);

    private int value;

    MerchantEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MerchantEnum fromValue(int value) {
        return Arrays.stream(values())
                .filter(t -> t.getValue() == value)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown merchant : " + value));
    }
}
