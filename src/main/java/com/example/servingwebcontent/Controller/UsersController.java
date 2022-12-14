package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.User;
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
	
	@GetMapping("/users")
	public String index(Model model) {
		Iterable<User> users = userRepository.findAll();
		model.addAttribute("users", users);
		return "users/index";
	}

	@GetMapping("/user/add")
	public String add() {
		return "users/add";
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
		return "users/edit";
	}

	@PostMapping("/user/update/{id}")
	public String update(@ModelAttribute User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return "redirect:/users";
	}

}