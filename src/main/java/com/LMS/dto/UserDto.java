package com.LMS.dto;

import com.LMS.entity.Authority;
import java.util.Set;

public class UserDto {

    private long id;
    private String email;
    private  String password;
    private Set<Authority> authority;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Authority> getAuthority() {
        return authority;
    }

    public void setAuthority(Set<Authority> authority) {
        this.authority = authority;
    }

    public UserDto(long id, String email, String password, Set<Authority> authority) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.authority = authority;
    }

    public UserDto(){

    }
}
