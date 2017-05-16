package de.uks.awe.webengineering.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by alexw on 16.05.2017.
 */

// The name "User" is a reserved name for postgres. That is, if we do not change the default name, everything will work
// fine locally but not after we deploy the application on heroku.
@Entity(name = "User_")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String email;
    @JsonIgnore
    private String password;

    public Long getId() {
        return id;
    }

    public User withId(Long id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User withPassword(String password) {
        this.password = password;
        return this;
    }
}
