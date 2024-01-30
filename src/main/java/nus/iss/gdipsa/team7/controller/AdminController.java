package nus.iss.gdipsa.team7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;
import nus.iss.gdipsa.team7.service.DashboardService;

@Controller
public class AdminController {
	
	@Autowired
	private DashboardService dashService;

	@GetMapping(value = {"/admin_home"})
	public String admin_home( HttpSession sessionObj, Model model) {
		String username = (String) sessionObj.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }
    	long getTotalGamers = dashService.getTotalGamers();
        long getTotalDevelopers = dashService.getTotalDevelopers();
        long getTotalGames = dashService.getTotalGames();
        long getGamesPendingReview = dashService.getGamesPendingReview();
        long getUserReports = dashService.getUserReports();
        
        model.addAttribute("username", username);
        
        model.addAttribute("totalGamers", getTotalGamers);
        model.addAttribute("totalDevelopers", getTotalDevelopers);
        model.addAttribute("totalGames", getTotalGames);
        model.addAttribute("gamesPendingReview", getGamesPendingReview);
        model.addAttribute("userReports", getUserReports);
        
       
		return "admin_home";
	}
}
