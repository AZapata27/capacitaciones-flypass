package com.courses.capacitacionesflypass.sesion3.d.testing.unit;

import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.entity.User;
import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.UserRepository;
import com.courses.capacitacionesflypass.sesion3.d.testing.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("Debería retornar el usuario cuando el usuario existe")
    public void getUserById_UsuarioExistente_DebeRetornarUsuario() {

        //El patrón Triple A (Arrange, Act, Assert)

        // Arrange (Preparar) DATOS
        User user = new User();
        user.setId(1L);
        user.setUsername("john_doe");
        user.setEmail("john@example.com");
            // Arrange (Preparar) MOCKS
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));


        // Act (Actuar)
        User foundUser = userService.getUserById(1L);

        // Assert (Afirmar)
        assertEquals("john_doe", foundUser.getUsername());
        assertEquals("john@example.com", foundUser.getEmail());

        verify(userRepository, times(1)).findById(1L);
    }


    @Test
    @DisplayName("Should return the user when the user exists")
    public void getUserById_UserExists_ShouldReturnUser() {
        // Arrange
        User user = new User();
        user.setId(1L);
        user.setUsername("john_doe");
        user.setEmail("john@example.com");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        // Act
        User foundUser = userService.getUserById(1L);

        // Assert
        assertEquals("john_doe", foundUser.getUsername());
        assertEquals("john@example.com", foundUser.getEmail());

        verify(userRepository, times(1)).findById(1L);
    }
}
