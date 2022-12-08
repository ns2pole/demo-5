package com.example.servingwebcontent.Controller;

import com.example.servingwebcontent.model.User;
import com.example.servingwebcontent.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.crypto.password.PasswordEncoder;

@Controller
public class UsersController {
	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserRepository userRepository;
	@GetMapping("/users")
	public String index(Model model) {
		return "users";
	}

	@PostMapping("/addUser")
	public String add(@ModelAttribute User user) {
		System.out.println(user.getPassword());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return "users";
	}


}