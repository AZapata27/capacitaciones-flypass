package com.courses.capacitacionesflypass.sesion2.a.anotation;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class PersonLombok {
    private String name;
    private int age;

}
