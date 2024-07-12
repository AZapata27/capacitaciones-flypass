package com.courses.capacitacionesflypass.sesion3.a.springIoC.senioradvance.scopes;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/scope")
public class ExampleController {

    private final CounterBean singletonBean;
    private final CounterBean singletonBean2;

    private final CounterBean prototypeBean;
    private final CounterBean prototypeBean2;
    private final CounterBean prototypeBean3;


    private final CounterBean applicationBean;

    public ExampleController(CounterBean singletonBean,
                             @Qualifier("singletonBean") CounterBean singletonBean2,
                             CounterBean prototypeBean,
                             @Qualifier("prototypeBean") CounterBean prototypeBean2,
                             @Qualifier("prototypeBean") CounterBean prototypeBean3,
                             CounterBean applicationBean) {
        this.singletonBean = singletonBean;
        this.singletonBean2 = singletonBean2;
        this.prototypeBean = prototypeBean;
        this.prototypeBean2 = prototypeBean2;
        this.prototypeBean3 = prototypeBean3;
        this.applicationBean = applicationBean;
    }

    @GetMapping("/singleton")
    public String getSingletonBean() {
        singletonBean.increment();
        return " -> " + singletonBean.getName() + ": " + singletonBean.getCount()
                + " -> " + singletonBean2.getName() + ": " + singletonBean2.getCount();
    }

    @GetMapping("/prototype")
    public String getPrototypeBean() {
        prototypeBean.increment();
        return   " -> " + prototypeBean.getName() + ": " + prototypeBean.getCount()
                + " -> " + prototypeBean2.getName() + ": " + prototypeBean2.getCount()
                + " -> " + prototypeBean3.getName() + ": " + prototypeBean3.getCount();
    }

    @GetMapping("/application")
    public String getApplicationBean() {
        applicationBean.increment();
        return applicationBean.getName() + ": " + applicationBean.getCount();
    }

}
