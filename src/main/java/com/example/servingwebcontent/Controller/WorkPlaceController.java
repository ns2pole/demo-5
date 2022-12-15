package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.WorkPlace;
import com.example.servingwebcontent.repository.WorkPlaceRepository;
import com.example.servingwebcontent.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WorkPlaceController {

	@Autowired
	WorkPlaceRepository masterWorkPlaceRepository;
	@GetMapping("/workPlace")
	public String index(Model model) {
		List<WorkPlace> workPlaceList = masterWorkPlaceRepository.findAll();
		model.addAttribute("workplaces", workPlaceList);
		return "workPlace";
	}

}