package com.example.servingwebcontent.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WorkPlaceController {
	@GetMapping("/workPlace")
	public String workPlace() {
		return "workPlace";
	}

}