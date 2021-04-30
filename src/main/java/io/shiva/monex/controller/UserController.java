
package io.shiva.monex.controller;

import io.shiva.monex.model.User;
import io.shiva.monex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping(path="/users",produces = "application/json")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping(path="/users")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping(path="/users/{id}",produces = "application/json")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user){
        return userService.updateUser(id, user);
    }

    @DeleteMapping(path="/users/{id}")
    public void deleteUser(@PathVariable("id") Long id){
       userService.deleteUser(id);
    }
}
