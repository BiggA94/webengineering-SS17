package de.uks.awe.webengineering.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by alexw on 16.05.2017.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository users;

    public User getUser(String email, String password) {
        return users.findUserByEmailAndAndPassword(email, password);
    }

    public Iterable<User> findAll() {
        return users.findAll();
    }
}
