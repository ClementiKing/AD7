package nus.iss.gdipsa.team7.controller;

import jakarta.servlet.http.HttpSession;
import nus.iss.gdipsa.team7.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DeveloperController {
    @Autowired
    private DashboardService dashService;
    @GetMapping(value = { "/developer_home" })
    public String developer_home(HttpSession sessionObj, Model model) {
        String username = (String) sessionObj.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }

        long getTotalGamers = dashService.getTotalGamers();
        double avgGamesRating = dashService.getAvgAccountGame(username);
        long getTotalGames = dashService.getTotalAccountGame(username);
        long getGamesPendingReview = dashService.getGamesPendingReview();
        long getUserReports = dashService.getUserReports();

        model.addAttribute("username", username);

        model.addAttribute("totalGamers", getTotalGamers);
        model.addAttribute("avgGamesRating", avgGamesRating);
        model.addAttribute("totalGames", getTotalGames);
        model.addAttribute("gamesPendingReview", getGamesPendingReview);
        model.addAttribute("userReports", getUserReports);

        return "developer_home";
    }
}
