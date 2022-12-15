package com.example.servingwebcontent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DivisionsController {
	@GetMapping("/divisions")
	public String index() {
		return "divisions";
	}

}