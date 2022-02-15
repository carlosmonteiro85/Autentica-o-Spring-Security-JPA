package br.com.examplesecurity.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.examplesecurity.security.dto.UserDTO;
import br.com.examplesecurity.security.service.AuthService;

@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	AuthService authService;
		
	@GetMapping("home")
	public String home() {
		return "home";
	}
	
	@GetMapping(value = {"" ,"login"})
	public String login() { 
		return "login";
	}
	
	@GetMapping("hello")
	public String hello(Model model) {
		
		UserDTO user = authService.getUserAuth();

		model.addAttribute("user", user);
		return "hello";
	}
	
	@GetMapping("adm")
	public String adm() {
		return "hello-adm";
	}
}
