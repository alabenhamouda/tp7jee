package com.example.tp5;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) private Integer id;

    private String login;
    private String password;
    private String email;
    private String country;
    private String state;

    public User() {}

    public User(String login, String password, String email, String country,
                String state) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.country = country;
        this.state = state;
    }

    public Integer getId() { return id; }
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
}
