package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.controller.bestPractices;

import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.entity.User;
import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PageableController {

    private final UserRepository userRepository;


    @GetMapping("/users")
    public Page<User> getUsersSimple(Pageable pageable) {

        return userRepository.findAll(pageable);
    }


    @GetMapping
    public Page<User> getUsersComplex() {

       Sort sort = Sort.by("username").descending()
               .and(Sort.by("email").ascending());


          /* Sort.Order order1 = new Sort.Order(Sort.Direction.DESC, "username");
           Sort.Order order2 = new Sort.Order(Sort.Direction.ASC, "email");

           Sort sort2 = Sort.by(order1, order2);*/

        Pageable pageableCustom = PageRequest.of(0, 10, sort);

        Page<User> userPage = userRepository.findAll(pageableCustom);

        for (User user : userPage.getContent() ) {
            System.out.println(user);
        }

        return userPage;
    }
}
