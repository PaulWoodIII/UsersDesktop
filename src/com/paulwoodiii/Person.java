package com.paulwoodiii;

import java.io.Serializable;

/**
 * Created by paul on 9/27/16.
 */
public class Person implements Serializable {
    String username;
    String email;
    String password;

    public Person(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Person() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        return String.format("%s email: %s passwordLength: %d",username,email,password.length());
    }
}
