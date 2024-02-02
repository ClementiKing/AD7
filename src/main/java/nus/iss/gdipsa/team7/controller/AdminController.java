package nus.iss.gdipsa.team7.controller;

import java.util.*;

import nus.iss.gdipsa.team7.model.Account;
import nus.iss.gdipsa.team7.model.Role;
import nus.iss.gdipsa.team7.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import nus.iss.gdipsa.team7.model.Game;
import nus.iss.gdipsa.team7.model.GameStatus;
import nus.iss.gdipsa.team7.service.DashboardService;
import nus.iss.gdipsa.team7.service.GameService;

@Controller
public class AdminController {

	@Autowired
	private DashboardService dashService;

	@Autowired
	private AccountService accountService;

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
		List game_list=new ArrayList();
		for (Game game:games){
			Map<String,Object> map=new HashMap<String,Object>();
//			int favorites_count=game.getUsersFavourite().size();
//			int shares_count=game.getUsersFavourite().size();
//			int reviews=game.getUsersFavourite().size();
//			int views=game.getUsersFavourite().size();
//			map.put("favoritesCount",favorites_count);
//			map.put("sharesCount",shares_count);
//			map.put("numberOfReviews",reviews);
//			map.put("pageViews",views);
			map.put("game",game);
			game_list.add(map);
		}
		model.addAttribute("games", game_list);
		return "admin_gamelist";
	}

	@GetMapping(value = { "/games-pending-review" })
	public String games_pending_review(HttpSession sessionObj, Model model) {
		List<Game> games = gameService.findByGameStatus(GameStatus.Pending);
		List game_list=new ArrayList();
		for (Game game:games){
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("game",game);
			game_list.add(map);
		}
		model.addAttribute("games", game_list);
		return "admin_games_pending_review_list";
	}



	@GetMapping("/games-pending-review-detail")
	public String games_pending_review_detail(@RequestParam("id") Integer Id, Model model) {
		Optional<Game> game = gameService.findGameById(Id);
		Game gg=game.get();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("game",gg);
		model.addAttribute("game", map);
		return "admin_games_pending_review";
	}

	@GetMapping("/search")
	public String searchGames(@RequestParam("query") String query, Model model) {
		List<Game> games = gameService.searchGames(query);
		model.addAttribute("games", games);
		return "admin_gamelist";
	}

	@GetMapping("/game-detail")
	public String viewGameDetail(@RequestParam("id") Integer Id, Model model) {
		Optional<Game> game = gameService.findGameById(Id);
		Game gg=game.get();
		Map<String,Object> map=new HashMap<String,Object>();
		int favorites_count=gg.getUsersFavourite().size();
		int shares_count=gg.getUsersFavourite().size();
		int reviews=gg.getUsersFavourite().size();
		int views=gg.getUsersFavourite().size();
		map.put("game",gg);
		map.put("favoritesCount",favorites_count);
		map.put("sharesCount",shares_count);
		map.put("numberOfReviews",reviews);
		map.put("pageViews",views);
		model.addAttribute("game", map);
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


	/*
	 * @GetMapping("/addGame") public String showAddGameForm(Model model) {
	 * model.addAttribute("game", new Game()); return "admin_addGame"; }
	 * 
	 * @PostMapping("/addGame") public String saveGame(@ModelAttribute("game") Game
	 * game, BindingResult result) { if (result.hasErrors()) { return
	 * "redirect:/game-list"; } return "redirect:/game-list"; }
	 */

	@PostMapping("/approve")
	public String Approve(Game game, BindingResult result) {
		gameService.approveGame(game.getId());
		if (result.hasErrors()) {
			return "redirect:/games-pending-review";
		}
		return "redirect:/games-pending-review";
	}
	
	@PostMapping("/reject")
	public String Reject(Game game, BindingResult result) {
		gameService.rejectGame(game.getId());

		if (result.hasErrors()) {
			return "redirect:/games-pending-review";
		}
		return "redirect:/games-pending-review";
	}
	
	@GetMapping("/admin-games-pending-approval")
	public String showPendingGames(Model model) {
	    List<Game> pendingGames = gameService.findByGameStatus(GameStatus.Pending);
	    model.addAttribute("pendingGames", pendingGames);
	    return "admin_games_pending_approval";
	}


	@GetMapping("/account-list" )
	public String account_list(HttpSession sessionObj, Model model) {
		List<Account> accountList_all = accountService.findByRoles(Role.User);
		List accountList=new ArrayList();

		for (Account acc:accountList_all){
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("account",acc);
			System.out.println(acc);
			accountList.add(map);
		}
		model.addAttribute("accounts", accountList);
		return "admin_account_list";
	}

	@PostMapping(value = { "/account-ban" })
	public String account_ban(Account acc,HttpSession sessionObj, Model model) {
		List<Account> accountList_all = accountService.findByRoles(Role.User);
		List accountList=new ArrayList();

		return "redirect:/admin_account_list";
	}
}
