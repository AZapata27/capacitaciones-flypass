package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.controller;

import org.springframework.stereotype.Component;

@Component
public class OwnerControllerSimple {

	public Pet findPet(Long ownerId,Long petId) {
		return new Pet();
	}
}
