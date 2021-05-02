package io.shiva.monex.repository;

import io.shiva.monex.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void clearDatabase(){
        userRepository.deleteAll();
    }

    @Test
    @DisplayName("Get All Users")
    void getAllUsers(){
        User user1 = new User("test1","test1@gmail.com","password");
        userRepository.save(user1);

        User user2 = new User("test2","test2@gmail.com","password");
        userRepository.save(user2);

        List<User> users = userRepository.findAll();
        assertThat(users.get(0).getEmail()).isEqualTo("test1@gmail.com");
        assertThat(users.get(1).getEmail()).isEqualTo("test2@gmail.com");
    }

    @Test
    @DisplayName("Creating new User")
    void createNewUser(){
        User user = new User("test1","test1@gmail.com","password");
        userRepository.save(user);

        Optional<User> user1 = userRepository.findUserByEmail("test1@gmail.com");
        assertThat(user1.get().getEmail()).isEqualTo("test1@gmail.com");
    }

    @Test
    @DisplayName("Delete existing User")
    void updateUser(){
        User user = new User("test1","test1@gmail.com","password");
        userRepository.save(user);

        Optional<User> user1 = userRepository.findUserByEmail("test1@gmail.com");
        assertThat(user1.get().getEmail()).isEqualTo("test1@gmail.com");

        userRepository.deleteById(user1.get().getId());

        List<User> users = userRepository.findAll();
        assertThat(users.size()).isEqualTo(0);
    }


}
