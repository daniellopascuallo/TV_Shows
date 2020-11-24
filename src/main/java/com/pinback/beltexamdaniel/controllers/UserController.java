package com.pinback.beltexamdaniel.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pinback.beltexamdaniel.models.LoginUser;
import com.pinback.beltexamdaniel.models.User;
import com.pinback.beltexamdaniel.services.UserService;

@Controller
public class UserController {
	
	private final UserService userServ;

	public UserController(UserService userServ) {
		this.userServ = userServ;
	}
	
	@GetMapping("/")
	public String signIn(Model model) {
	    model.addAttribute("registerUser", new User());
	    model.addAttribute("loginUser", new LoginUser());
	    return "index.jsp";
	}
	
	@PostMapping("/register")
	public String create(@Valid @ModelAttribute("registerUser") User registerUser, BindingResult result, Model model, HttpSession session) {
	    if(!registerUser.getPassword().equals(registerUser.getConfirm())) {
	        result.rejectValue("confirm", "Match", "Passwords must match");
	    }
	    if(userServ.getUser(registerUser.getEmail()) != null) {
	        result.rejectValue("email", "Unique", "Email already in use");
	    }
	    if(result.hasErrors()) {
	    	model.addAttribute("loginUser", new LoginUser());
	        return "index.jsp";
	    } else {
	        session.setAttribute("user", userServ.create(registerUser));
	        return "redirect:/shows";            
	    }
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult result, Model model, HttpSession session) {
	    User loggingInUser = userServ.login(loginUser, result);
	    if(result.hasErrors()) {
	        model.addAttribute("registerUser", new User());
	        return "index.jsp";
	    } else {
	        session.setAttribute("user", loggingInUser);
	        return "redirect:/shows";         
	    }   
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	    session.removeAttribute("user");;
	    return "redirect:/";
	}


}
