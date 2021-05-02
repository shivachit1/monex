package io.shiva.monex.service;

import io.shiva.monex.model.Expense;
import io.shiva.monex.model.User;
import io.shiva.monex.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User createUser(User user){
        Optional<User> user1= userRepository.findUserByEmail(user.getEmail());
        if(user1.isPresent()) throw new IllegalStateException("User with email already exists");
        return userRepository.save(user);
    }

    @Transactional
    public User updateUser(Long id, User user){
        boolean exists = userRepository.existsById(id);
        if(!exists) throw new IllegalStateException("User not found");

        Optional<User> optionalUser = userRepository.findUserByEmail(user.getEmail());
        if(!optionalUser.isPresent()) throw new IllegalStateException("Email Already Taken");

        Optional<User> user1=userRepository.findById(id);
        user1.get().setEmail(user.getEmail());
        user1.get().setName(user.getName());
        user1.get().setPasswordHash(user.getPasswordHash());
        return userRepository.save(user1.get());
    }

    public void deleteUser(Long id){
        boolean exists = userRepository.existsById(id);
        if(!exists) throw new IllegalStateException("User not found");
        userRepository.deleteById(id);
    }
}
