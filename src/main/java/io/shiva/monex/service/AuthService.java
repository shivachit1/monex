package io.shiva.monex.service;

import io.shiva.monex.model.User;
import io.shiva.monex.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService implements UserDetailsService {

    public final UserRepository userRepository;

    @Autowired
    public AuthService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public User authenticateUser(String email, String password){
        Optional<User> user = userRepository.findUserByEmail(email);
        return user.get();
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}

