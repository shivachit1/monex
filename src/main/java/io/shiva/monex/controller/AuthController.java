package io.shiva.monex.controller;

import io.shiva.monex.model.User;
import io.shiva.monex.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService){
        this.authService=authService;
    }

    @PostMapping(path="/authenticate")
    public User createUser(@RequestParam("email") String email,
                           @RequestParam("password") String password){
        return authService.authenticateUser(email,password);
    }

}
