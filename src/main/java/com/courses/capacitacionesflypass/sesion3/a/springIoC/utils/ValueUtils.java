package com.courses.capacitacionesflypass.sesion3.a.springIoC.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Component
public class ValueUtils {

    @Value("${my.other.property:Default Value}")
    private String myProperty;

    @Value("#{'${my.list}'.toUpperCase()}")
    private List<String> myList;

    @Value("#{${my.map}}")
    private Map<String, String> myMap;

    @Value("#{systemProperties['user.home']}")
    private String userHome;

    @Value("#{systemProperties['java.version'].startsWith('1.8') ? 'Java 8' : 'Not Java 8'}")
    private String javaVersionCondition;

    @PostConstruct
    public void init() {
        System.out.println("Property value: " + myProperty);
        System.out.println("List: " + myList);

        System.out.println("Map values: " + myMap);
        System.out.println("User home: " + userHome);

        System.out.println("Java Version Condition: " + javaVersionCondition);
    }
}