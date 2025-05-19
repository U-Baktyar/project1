package org.example.model.user;

import java.util.Objects;

public class Customer extends User {
    private boolean isLocked;

    public Customer() {}

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isLocked);  // добавляем isLocked в hashCode
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;  // проверяем equals у User
        Customer customer = (Customer) obj;
        return isLocked == customer.isLocked;
    }
}
