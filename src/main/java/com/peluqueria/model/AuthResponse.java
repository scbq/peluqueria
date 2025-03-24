package com.peluqueria.model;

public class AuthResponse {
    private String token;
    private String role;

    // Constructor vacío
    public AuthResponse() {
    }

    // Constructor con token y rol
    public AuthResponse(String token, String role) {
        this.token = token;
        this.role = role;
    }

    // Getters y Setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
