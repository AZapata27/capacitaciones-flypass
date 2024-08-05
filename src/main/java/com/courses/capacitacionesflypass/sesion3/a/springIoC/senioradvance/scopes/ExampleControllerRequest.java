package com.courses.capacitacionesflypass.sesion3.a.springIoC.senioradvance.scopes;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;


@RestController
@RequestMapping("/scope")
@RequiredArgsConstructor
@RequestScope
public class ExampleControllerRequest {

    private final CounterBean requestBean;


    @GetMapping("/request")
    public String getRequestBean() {
        requestBean.increment();
        return requestBean.getName() + ": " + requestBean.getCount();
    }


}
