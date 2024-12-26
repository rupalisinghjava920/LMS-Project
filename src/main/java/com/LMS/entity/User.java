package com.LMS.entity;

import jakarta.persistence.*;
import java.util.Set;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private Set<Authority> authority;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public User(Long id, String email, String password, Set<Authority> authority) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.authority = authority;
    }

    public User(){

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", authority=" + authority +
                '}';
    }
}
