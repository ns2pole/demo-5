package com.example.servingwebcontent.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DivisionsController {
	@GetMapping("/divisions")
	public String division() {
		return "divisions";
	}

}