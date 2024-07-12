package com.courses.capacitacionesflypass.sesion3.a.springIoC.senioradvance.scopes;

import lombok.Getter;

import java.util.Random;

@Getter
public class CounterBean {
    private final String name;
    private int count;

    public CounterBean(String name) {
        this.name = name + "-" + (new Random().nextInt(500) + 1);
        this.count = 0;
    }

    public void increment() {
        this.count++;
    }
}