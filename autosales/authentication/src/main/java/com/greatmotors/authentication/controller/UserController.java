package com.greatmotors.authentication.controller;

import com.greatmotors.authentication.exceptions.UserAlreadyExistsException;
import com.greatmotors.authentication.model.TempUser;
import com.greatmotors.authentication.model.User;
import com.greatmotors.authentication.service.SecurityTokenGenerator;
import com.greatmotors.authentication.service.SecurityTokenGeneratorImpl;
import com.greatmotors.authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private SecurityTokenGenerator securityTokenGenerator;

    // http://localhost:8085/user/signup       [post]
    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody TempUser tempUser) throws UserAlreadyExistsException {
        try {
            User user = userService.signUp(tempUser);
            user.setPassword(null);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        catch (Exception e){
            throw new UserAlreadyExistsException();
        }
    }

    // http://localhost:8085/user/login       [post]
    @PostMapping("/login")
    public ResponseEntity<?> logIn(@RequestBody User user) {
        User resUser = userService.logIn(user);
        if(resUser==null){
            return new ResponseEntity("Login failed",HttpStatus.NOT_FOUND);
        }
        resUser.setPassword(null);
        return new ResponseEntity<>(securityTokenGenerator.generateToken(resUser), HttpStatus.OK);
    }


}
