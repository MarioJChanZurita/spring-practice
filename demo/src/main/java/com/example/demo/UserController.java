package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody User user){
        this.userService.addUser(user);
    }

    @GetMapping("/findAllUsers")
    public List<User> getUsers(){
        return this.userService.getUsers();
    }

    @GetMapping("/findUser/{id}")
    public Optional<User> getUser(@PathVariable Long id){
        return this.userService.getUser(id);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable Long id){
        this.userService.deleteUser(id);
    }

    @PutMapping("/updateUser/{id}")    
    public void updateUser(
        @PathVariable(value="id") Long userId, 
        @RequestBody User updatedUser
    ) {
        this.userService.updateUser(updatedUser, userId);
    }

}
