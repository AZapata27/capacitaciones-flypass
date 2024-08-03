package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.repository.criteria;

import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    private final UserRepositoryCriteria userRepository;

    public UserService(UserRepositoryCriteria userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<User> findUsersCreatedAfter(LocalDateTime date) {
        return userRepository.findAll(UserSpecifications.createdAfter(date));
    }
}
