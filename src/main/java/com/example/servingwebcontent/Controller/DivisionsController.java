package com.example.servingwebcontent.Controller;

import com.example.servingwebcontent.repository.DivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DivisionsController {
	@Autowired
	DivisionRepository divisionRepository;

	@GetMapping("/divisions")
	public String index(Model model) {
		model.addAttribute("divisions", divisionRepository.findAll());
		return "roleAdmin/divisions";
	}

}