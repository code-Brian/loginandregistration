package com.loginandregistration.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.loginandregistration.services.UserService;

@Controller
public class MainController {
	
	@Autowired
	private UserService userServ;
	
	@GetMapping("/dashboard")
	public String index(Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userServ.getOne(userId));
		return "index.jsp";
	}
}
