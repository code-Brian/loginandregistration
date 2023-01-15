package com.loginandregistration.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.loginandregistration.models.LoginUser;
import com.loginandregistration.models.User;
import com.loginandregistration.services.UserService;

@Controller
public class LoginController {
	@Autowired
	UserService userServ;
	
	@GetMapping("/login")
	public String login(@ModelAttribute("user") User user) {
		return "login.jsp";
	}
	
	@PostMapping("/login/create")
	public String createLogin(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "login.jsp";
		} else {
			// On success
			// User LoginService to create a new user and store their info in the DB
			// Also store user id in session so we may determin login status
			// Upon successful creation of user and validation, redirect to home page
			userServ.create(user);
			return "redirect:/";
		}
	}
	
}
