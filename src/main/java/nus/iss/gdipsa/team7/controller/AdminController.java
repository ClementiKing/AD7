package nus.iss.gdipsa.team7.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import nus.iss.gdipsa.team7.model.Game;
import nus.iss.gdipsa.team7.repository.GameRepository;
import nus.iss.gdipsa.team7.service.DashboardService;
import nus.iss.gdipsa.team7.service.GameService;

@Controller
public class AdminController {

	@Autowired
	private DashboardService dashService;

	@Autowired
	private GameService gameService;

	@GetMapping(value = { "/admin_home", "/admin-dashboard" })
	public String admin_home(HttpSession sessionObj, Model model) {
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

	@GetMapping(value = { "/game-popularList" })
	public String admin_game_popularGames(HttpSession sessionObj, Model model) {
		List<Game> games = gameService.findTop10ByRating();
		model.addAttribute("games", games);
		return "admin_gamelist_populargame";
	}

	@GetMapping(value = { "/game-list" })
	public String admin_game_gameList(HttpSession sessionObj, Model model) {
		List<Game> games = gameService.findAllGames();
		model.addAttribute("games", games);
		return "admin_gamelist";
	}

	@GetMapping("/search")
	public String searchGames(@RequestParam("query") String query, Model model) {
		List<Game> games = gameService.searchGames(query);
		model.addAttribute("games", games);
		return "admin_gamelist";
	}

	@GetMapping("/game-detail/{id}")
	public String viewGameDetail(@PathVariable("id") Integer Id, Model model) {
		Optional<Game> game = gameService.findGameById(Id);
		model.addAttribute("game", game);
		return "admin_gameDetail";
	}
	
	@PostMapping("/saveGameDetails")
	public String saveGameDetails(@ModelAttribute("game") Game game, BindingResult result) {
	    if (result.hasErrors()) {
	        return "admin_gameDetail";
	    }
	    gameService.save(game);
	    return "redirect:/game-list";
	}


	@GetMapping("/addGame")
	public String showAddGameForm(Model model) {
		model.addAttribute("game", new Game());
		return "admin_addGame";
	}

	@PostMapping("/addGame")
	public String saveGame(@ModelAttribute("game") Game game, BindingResult result) {
		if (result.hasErrors()) {
			return "admin_addGame";
		}
		return "redirect:/game-list";
	}
	
	
	@GetMapping("/admin-games-pending-approval")
	public String showPendingGames(Model model) {
	    List<Game> pendingGames = gameService.findByIsApprovedFalse();
	    model.addAttribute("pendingGames", pendingGames);
	    return "admin_games_pending_approval";
	}
	
}
