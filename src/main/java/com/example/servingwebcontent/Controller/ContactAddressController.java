package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.ContactAddress;
import com.example.servingwebcontent.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.servingwebcontent.repository.ContactAddressRepository;
@Controller
public class ContactAddressController {

	@Autowired
	ContactAddressRepository contactAddressRepository;
	@GetMapping("/contactAddress")
	//useridだけ欲しいのだが。
	public String index(@AuthenticationPrincipal User user, Model model) {
		model.addAttribute("contact_address", contactAddressRepository.findByUserId(user.getId()).get());
		return "roleUser/contactAddress";
	}

	@PostMapping("/contactAddress/update")
	public String update(@AuthenticationPrincipal User user, @ModelAttribute ContactAddress ca) {
		ContactAddress tmp = contactAddressRepository.findByUserId(user.getId()).get();
		tmp.setEmail(ca.getEmail());
		tmp.setPhone(ca.getPhone());
		contactAddressRepository.save(tmp);
		return "redirect:/contactAddress";
	}

}