package com.courses.capacitacionesflypass.sesion2.b.serializationdeserialization;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Persona implements Serializable {

    private int edad;
    private String nombre;
    private String apellido;

    private transient String transientAtribute;
    private transient String datoQueNoSeDebeSerializar;

    public Persona(int edad, String nombre, String apellido) {
        this.edad = edad;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "edad=" + edad +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }

}
