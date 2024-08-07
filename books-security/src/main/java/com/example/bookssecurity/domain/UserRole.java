package com.example.bookssecurity.domain;

import org.springframework.security.core.GrantedAuthority;

public class UserRole implements GrantedAuthority {

    private Role role;

    @Override
    public String getAuthority() {
        return "ROLE_" + role.name().toLowerCase();
    }
}
