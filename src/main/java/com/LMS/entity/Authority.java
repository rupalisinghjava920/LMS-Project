package com.LMS.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tabl_authority")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String authority;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Authority(Long id, String authority, User user) {
        this.id = id;
        this.authority = authority;
        this.user = user;
    }

    public Authority(){

    }

    @Override
    public String toString() {
        return "Authority{" +
                "id=" + id +
                ", authority='" + authority + '\'' +
                ", user=" + user +
                '}';
    }
}
