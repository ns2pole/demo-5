package com.example.servingwebcontent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class LoginController {

	@GetMapping("/")
	public String loginForm(Model model) {
		return "loginForm";
	}

}