package org.example.model.user;

import java.util.Objects;

public class Admin extends User {
    private String access;
    private String position;

    public Admin() {}

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), access, position);  // добавляем access и position в hashCode
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;  // проверяем equals у User
        Admin admin = (Admin) obj;
        return Objects.equals(access, admin.access) && Objects.equals(position, admin.position);
    }
}
