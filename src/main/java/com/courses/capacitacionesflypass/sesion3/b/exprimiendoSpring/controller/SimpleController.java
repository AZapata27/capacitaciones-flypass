package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.controller;

import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.controller.dto.MyObject;
import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.controller.dto.Pet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.Principal;

@Controller
public class SimpleController {

	@RequestMapping(path = "/pets/{petId}", consumes = "application/json", produces = "application/json", method = RequestMethod.GET)
	@GetMapping(value = "/pets/{petId}", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Pet findPet(@PathVariable Long ownerId, @PathVariable Long petId) {
		return new Pet();
	}


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
	public MyObject getJsonExmaple(@RequestParam(name = "name", defaultValue = "World", required = false) String name) {
		return new MyObject("value1", name);
	}


	@GetMapping("/greeting")
	public String greeting(HttpServletRequest request,
						   HttpServletResponse response,
						   Principal principal) {
		// Puedes acceder a la solicitud, respuesta y principal aquí
		return "Hello, " + principal.getName();
	}

	@GetMapping("/check-header")
	public String checkHeader(@RequestHeader("User-Agent") String userAgent) {
		// Aquí puedes usar el valor del encabezado User-Agent
		return "User-Agent: " + userAgent;
	}

	@GetMapping("/get-cookie")
	public String getCookie(@CookieValue("sessionId") String sessionId) {
		// Aquí puedes usar el valor de la cookie sessionId
		return "Session ID: " + sessionId;
	}



	@GetMapping("/setCookie")
	public String setCookie(HttpServletResponse response) {
		Cookie cookie = new Cookie("theme", "dark");
		cookie.setMaxAge(7 * 24 * 60 * 60); // Cookie dura 7 días
		response.addCookie(cookie);
		return "Cookie set";
	}

	@GetMapping("/downloadFile")
	public void downloadFile(HttpServletResponse response) throws IOException {
		String filePath = "/path/to/your/file.txt";
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=file.txt");

		try (FileInputStream fileInputStream = new FileInputStream(filePath);
			 OutputStream outputStream = response.getOutputStream()) {
			byte[] buffer = new byte[4096];
			int bytesRead;
			while ((bytesRead = fileInputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}
		}
	}

	@GetMapping("/checkCondition")
	public void checkCondition(HttpServletResponse response) throws IOException {
		boolean condition = checkSomeCondition();
		if (condition) {
			response.sendRedirect("/successPage");
		} else {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Condition failed");
		}
	}

	private boolean checkSomeCondition() {
		// Lógica para verificar la condición
		return false;
	}

}






