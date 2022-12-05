package com.example.servingwebcontent.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class LoginController {

	@GetMapping("/loginForm")
	public String loginForm(Model model) {
		return "loginForm";
	}

}