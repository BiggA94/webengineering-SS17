package de.uks.awe.webengineering.authentication;

import de.uks.awe.webengineering.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alexw on 16.05.2017.
 */
@RestController
@RequestMapping("/user")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    public static class UserLogin {
        public String email;
        public String password;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<AuthenticationService.UserToken> login(@RequestBody UserLogin userLogin){
        AuthenticationService.UserToken token = authenticationService.login(userLogin.email, userLogin.password);

        if (token == null){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @RequestMapping("ShowAllUsers")
    public Iterable<User> showUsers(){
        return authenticationService.getUsers();
    }
}
