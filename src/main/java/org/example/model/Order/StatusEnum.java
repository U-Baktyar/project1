package org.example.model.Order;


public enum StatusEnum {
    PENDING("В ожидании"),
    PROCESSING("Обрабатывается"),
    SHIPPED("Отправлен"),
    DELIVERED("Доставлен"),
    CANCELLED("Отменён");

    private final String status;

    StatusEnum (String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public static StatusEnum fromString(String status) {
        for (StatusEnum statusEnum : StatusEnum.values()) {
            if (statusEnum.getStatus().equalsIgnoreCase(status)) {
                return statusEnum;
            }
        }
        throw new IllegalArgumentException("Неизвестный статус: " + status);
    }

}
