package nus.iss.gdipsa.team7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import nus.iss.gdipsa.team7.model.Account;
import nus.iss.gdipsa.team7.service.AccountService;

@Controller
public class HomeController {
	@Autowired
	private AccountService accService;

	@GetMapping(value = {"/", "/login"})
	public String login(Model model) {
		model.addAttribute("account", new Account());
		return "login";
	}
	
	@PostMapping(value = "/authenticate")
	public String handleLogin(@ModelAttribute("account") Account accForm, BindingResult bindingResult, Model model, HttpSession sessionObj) {
		if(bindingResult.hasErrors()) {
			return "login";
		}
		
		Account acc = accService.authenticate(accForm.getUsername(), accForm.getPassword());	
		
		if(acc.getRoles().contains("Administrator")) {
			return "admin_home";
		}
		
		if(acc.getRoles().contains("Developer")) {
			return "developer_home";
		}
		
		model.addAttribute("errorMsg", "Invalid Username or Password. Please try again.");
		return "login";
	}

}