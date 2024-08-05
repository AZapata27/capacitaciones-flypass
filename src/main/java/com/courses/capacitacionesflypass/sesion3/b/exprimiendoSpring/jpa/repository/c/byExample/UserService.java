package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.c.byExample;

import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findUsersByUsername(String username) {
        User userProbe = new User();
        userProbe.setUsername(username);

        Example<User> example = Example.of(userProbe);
        return userRepository.findAll(example);
    }

    public List<User> findUsersByPartialUsername(String partialUsername) {
        User userProbe = new User();
        userProbe.setUsername(partialUsername);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("username", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

        Example<User> example = Example.of(userProbe, matcher);
        return userRepository.findAll(example);
    }
}
