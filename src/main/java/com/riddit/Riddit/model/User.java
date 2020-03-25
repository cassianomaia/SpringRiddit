package com.riddit.Riddit.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="user_account")
public class User {

    @Id
    private String email;
    private String password;
    // TODO: Add TextList: OneToMany List<Text> and CommentList: OneToMany List<Comment>

    public User() {

    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
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

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
