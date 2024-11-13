package com.example.desafio_junior_backend_simplify.model.enums;

public enum UserRole {
    ADMIN("admin"),
    USER("admin");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
