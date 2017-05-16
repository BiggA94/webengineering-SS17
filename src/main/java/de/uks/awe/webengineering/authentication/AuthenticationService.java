package de.uks.awe.webengineering.authentication;

import de.uks.awe.webengineering.user.User;
import de.uks.awe.webengineering.user.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * Created by alexw on 16.05.2017.
 */
@Service
public class AuthenticationService {
    @Autowired
    private UserService userService;

    private String secret = "My Secret Message is '42'!";

    /**
     * Return object containing a valid user and his corresponding JWT token.
     */
    public static class UserToken {
        public User user;
        public String token;
    }


    /**
     * Create a JWT token and additional user information if the user's credentails are valid.
     *
     * @param email    email
     * @param password password
     * @return a UserToken or null if the credentials are not valid
     */
    public UserToken login(String email, String password) {
        User user = userService.getUser(email, password);
        if (user == null) {
            return null;
        }

        String token = Jwts.builder()
                .setSubject(email)
                .setId(user.getId().toString())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();

        UserToken userToken = new UserToken();
        userToken.user = user;
        userToken.token = token;
        return userToken;
    }


    /**
     * Validate that a token is valid and returns its body.
     *
     * Throws a SignatureException if the token is not valid.
     * @param jwtToken JWT token
     * @return JWT body
     */
    public Object parseToken(String jwtToken) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parse(jwtToken)
                .getBody();
    }

    /**
     * Set a user for the current request.
     *
     * @param id user id
     * @param email user email
     */
    public void setUser(Long id, String email) {
        User user = new User();
        user.withId(id);
        user.withEmail(email);
        UsernamePasswordAuthenticationToken secAuth = new UsernamePasswordAuthenticationToken(user, null);
        SecurityContextHolder.getContext().setAuthentication(secAuth);
    }

    public Iterable<User> getUsers(){
        return userService.findAll();
    }
}
