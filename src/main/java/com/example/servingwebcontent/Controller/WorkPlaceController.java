package com.example.servingwebcontent.Controller;

import com.example.servingwebcontent.enums.WorkPlace;
import com.example.servingwebcontent.repository.DivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class WorkPlaceController {
	@Autowired
	DivisionRepository divisionRepository;

	@GetMapping("/workPlace")
	public String index(Model model) {
		model.addAttribute("workPlaces", WorkPlace.values());
		return "roleUser/workPlace";
	}

}