package com.example.servingwebcontent.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MasterWorkPlacesController {
	@GetMapping("/masterWorkPlaces")
	public String workPlace() {
		return "masterWorkPlaces";
	}

}