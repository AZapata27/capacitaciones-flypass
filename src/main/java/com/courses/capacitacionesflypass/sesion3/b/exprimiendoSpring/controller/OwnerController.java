package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/owners/{ownerId}")
public class OwnerController {

	@RequestMapping(path = "/pets/{petId}", consumes = "application/json", produces = "application/json", method = RequestMethod.GET)
	@GetMapping(value = "/pets/{petId}", consumes = "application/json", produces = "application/json")
	public Pet findPet(@PathVariable Long ownerId, @PathVariable Long petId) {
		return new Pet();
	}
}






