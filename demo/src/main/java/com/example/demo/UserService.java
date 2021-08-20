package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void addUser(User user){
        this.userRepository.save(user);
    }

    public List<User> getUsers(){
        return this.userRepository.findAll();
    }

    public Optional<User> getUser(Long id){
        return this.userRepository.findById(id);
    }

    public void deleteUser(Long id) {
        this.userRepository.deleteById(id);
    }

    public void updateUser(User updatedUser, Long id) {
        User user = this.userRepository.findById(id).orElse(null);
        user = updatedUser;
        this.userRepository.save(user);
    }

}
