package com.example.servingwebcontent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MasterWorkPlacesController {
	@GetMapping("/masterWorkPlaces")
	public String index() {
		return "masterWorkPlaces";
	}

}