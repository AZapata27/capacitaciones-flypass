package com.courses.capacitacionesflypass.sesion3.a.springIoC.senioradvance.scopes;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;


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
