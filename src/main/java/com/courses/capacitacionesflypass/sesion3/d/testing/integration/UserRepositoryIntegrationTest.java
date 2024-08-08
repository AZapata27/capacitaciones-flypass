package com.courses.capacitacionesflypass.sesion3.d.testing.integration;

import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.DemoJpaApplication;
import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.entity.User;
import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = DemoJpaApplication.class)
public class UserRepositoryIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("Should save and then find user by ID")
    public void saveAndFindUser_WhenValidData_ShouldReturnUser() {

        // Arrange (set up data)
        User user = new User();
        user.setUsername("john_doe");
        user.setEmail("john@example.com");
        user = userRepository.saveAndFlush(user);


        // Act (retrieve the user)
        Optional<User> foundUser = userRepository.findById(user.getId());

        // Assert (verify the results)
        assertTrue(foundUser.isPresent());
        assertEquals("john_doe", foundUser.get().getUsername());
        assertEquals("john@example.com", foundUser.get().getEmail());
    }
}
