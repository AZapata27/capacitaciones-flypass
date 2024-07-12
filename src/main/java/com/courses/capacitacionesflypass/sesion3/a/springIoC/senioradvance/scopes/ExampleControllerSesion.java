package com.courses.capacitacionesflypass.sesion3.a.springIoC.senioradvance.scopes;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/scope")
@RequiredArgsConstructor
@SessionScope
public class ExampleControllerSesion {

    private final CounterBean sessionBean;


    @GetMapping("/session")
    public String getSessionBean(HttpSession session) {
        sessionBean.increment();
        return sessionBean.getName() + ": " + sessionBean.getCount();
    }

}
