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
	private UserService userServ;
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("loginUser", new LoginUser());
		return "login.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userId");
		return "redirect:/login";
	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
		// We need to add some DB validations
		// This can be done in the Service module 
		// Head on over and take a look!
		// This checks to see if passwords match
		// If they don't, a custom error message is added from the Service
		User createdUser =  userServ.register(user, result);
		if(createdUser == null) {
			// These are only model level validations
			model.addAttribute("loginUser", new LoginUser());
			return "login.jsp";
		} else {
			// On success
			// User LoginService to create a new user and store their info in the DB
			// Also store user id in session so we may determin login status
			// Upon successful creation of user and validation, redirect to home page
			
			session.setAttribute("userId", createdUser.getId());
			return "redirect:/dashboard";
		}
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("loginUser") LoginUser logUser, BindingResult result, HttpSession session, Model model) {
		User loggedUser = userServ.login(logUser, result);
		if(loggedUser == null) {
			model.addAttribute("user", new User());
			return "login.jsp";
		}
		session.setAttribute("userId", loggedUser.getId());
		return "redirect:/dashboard";
	}
	
	
}
