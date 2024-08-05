package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

@Configuration
public class ExplicitControllerConfig {

	@Autowired
	public void setHandlerMapping(RequestMappingHandlerMapping mapping, SimpleController handler)
			throws NoSuchMethodException {

		RequestMappingInfo info = RequestMappingInfo
				.paths("/owners/{ownerId}/user/{id}")
				.methods(RequestMethod.GET).build();

		Method method = SimpleController.class.getMethod("findPet", Long.class, Long.class);

		mapping.registerMapping(info, handler, method);
	}
}