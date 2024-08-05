package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyObject {
    private String field1;
    private String field2;

    public MyObject(String field1, String field2) {
        this.field1 = field1;
        this.field2 = field2;
    }


}