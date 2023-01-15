package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.User;
import com.example.servingwebcontent.repository.DivisionRepository;
import com.example.servingwebcontent.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Controller
public class UsersController {
	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserRepository userRepository;
	@Autowired
	DivisionRepository divisionRepository;

	@GetMapping("/users")
	public String index(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "roleAdmin/users/index";
	}

	@GetMapping("/user/add")
	public String add(Model model) {
		model.addAttribute("divisions", divisionRepository.findAll());
		return "roleAdmin/users/add";
	}

	@PostMapping("/user/create")
	public String create(@ModelAttribute User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return "redirect:/users";
	}


	@GetMapping("/user/edit/{id}")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("user", userRepository.findById(id).get());
		model.addAttribute("divisions", divisionRepository.findAll());
		return "roleAdmin/users/edit";
	}

	@PostMapping("/user/update/{id}")
	public String update(@ModelAttribute User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return "redirect:/users";
	}


	@PostMapping("/user/delete/{id}")
	public String delete(@ModelAttribute User user) {
		userRepository.delete(user);
		return "redirect:/users";
	}
}