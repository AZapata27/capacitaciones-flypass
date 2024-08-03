package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
@ResponseBody
public class MappingRestControllerExample {
    
    @RequestMapping("/json")
    @ResponseBody
    public MyObject getJson() {
        return new MyObject("value1", "value2");
    }

    @GetMapping
    @PostMapping
    @PutMapping
    @DeleteMapping
    @PatchMapping
    public MyObject getJsonExmaple() {
        return new MyObject("value1", "value2");
    }




}






