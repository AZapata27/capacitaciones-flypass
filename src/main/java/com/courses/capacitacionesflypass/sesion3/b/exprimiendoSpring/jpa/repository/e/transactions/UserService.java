package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.e.transactions;

import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void updateUserEmail(Long id, String newEmail) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));


        user.setEmail(newEmail);
        user.setUsername("newUsername");

        // No es necesario llamar a userRepository.save(user); aquí

        otherMethod(id, newEmail);
    }


    @Transactional(timeout = 10, propagation = Propagation.REQUIRES_NEW)
    public void otherMethod(Long id, String newEmail) {

        userRepository.deleteInactiveUsers();

    }


}
