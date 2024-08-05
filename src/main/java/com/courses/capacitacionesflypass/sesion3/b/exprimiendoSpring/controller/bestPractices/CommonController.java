package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.controller.bestPractices;

import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.controller.bestPractices.exceptions.BussinessException;
import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.entity.Post;
import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.entity.User;
import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/v1/users", consumes = MediaType.APPLICATION_JSON_VALUE)
// Indicamos el recurso que vamos a utilizar para el controller con su version
// Indicamos que solo puede consumir JSON evitando ataques de Cross-Site Scripting (XSS), Content Type Confusion o Content Type Sniffing

@RequiredArgsConstructor
public class CommonController {

    private final UserRepository userRepository;

    @GetMapping
    public Page<User> getUsersPage(Pageable pageable) {

        return userRepository.findAll(pageable);
    }

    @GetMapping("/{userId}")
    public User getUsersById(@PathVariable Long userId) {

        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    @GetMapping("/{userId}/posts")
    public List<Post> getUsersPost(@PathVariable Long userId) {


        Optional<User> user = userRepository.findById(userId); // Con esta verificacion dariamos Indempotencia a la operacion POST

        if (user.isPresent()) {
            return user.get().getPosts();
        } else {
            throw new EntityNotFoundException("User not found");
        }

    }

    @PostMapping
    public ResponseEntity<User> createUserPost(@RequestBody User user) {

            User userSaved = userRepository.save(user);
            URI location = URI.create("/v1/users/" + userSaved.getId());
            return ResponseEntity.created(location).body(userSaved);

//       return ResponseEntity.status(HttpStatus.CREATED).body(userSaved);


    }

    @PutMapping
    public ResponseEntity<User> createUserPut(@RequestBody User user) {

        Optional<User> existingUserOpt = userRepository.findByEmail(user.getEmail());

        if (existingUserOpt.isPresent()) {
            User existingUser = existingUserOpt.get();

            // verificamos si el usuario ya existe y no fue modificado
            if (existingUser.equals(user)) {
                return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
            } else {
                // Update the user with new data
                user.setId(existingUser.getId());
                User updatedUser = userRepository.save(user);
                return ResponseEntity.ok(updatedUser);
            }
        } else {
            // Create a new user
            User userSaved = userRepository.save(user);
            URI location = URI.create("/v1/users/" + userSaved.getId());
            return ResponseEntity.created(location).body(userSaved);
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUser(@RequestParam Long userId) {
        userRepository.deleteById(userId);
        return ResponseEntity.noContent().build();
    }


    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException e) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(BussinessException.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.internalServerError().body(e.getMessage());
    }


}
