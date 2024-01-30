package nus.iss.gdipsa.team7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {

	@GetMapping(value = {"/admin_home"})
	public String admin_home( HttpSession sessionObj, Model model) {
		String username = (String) sessionObj.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }
        
        model.addAttribute("username", username);
        
        
		return "admin_home";
	}
}