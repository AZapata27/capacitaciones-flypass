package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.aa.projections;

import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.aa.projections.projections.UserDto;
import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.aa.projections.projections.UserEmailNames;
import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.aa.projections.projections.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceProjections {


    private final UserRepository userRepository;


    public UserInfo getUserInfo(){
        return userRepository.findByUsername("user1").orElseThrow();
    }


    public List<UserEmailNames> getUserEmailNames() {
        return userRepository.findAllProjectedBy(UserEmailNames.class);
    }

    public List<UserDto> getUserComplete() {
        return userRepository.findAllProjectedBy(UserDto.class);
    }

}
