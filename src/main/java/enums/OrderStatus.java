package enums;

public enum OrderStatus {

    PROCESSING("Processing", 1),
    SHIPPED("Shipped", 2),
    DELIVERED("Delivered", 3),
    CANCELED("Canceled", 4);

    private final String key;
    private final Integer value;

    OrderStatus(String key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }
    public Integer getValue() {
        return value;
    }

}
