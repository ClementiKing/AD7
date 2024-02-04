package nus.iss.gdipsa.team7.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import nus.iss.gdipsa.team7.model.Account;
import nus.iss.gdipsa.team7.model.Game;
import nus.iss.gdipsa.team7.model.GameStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nus.iss.gdipsa.team7.model.Role;
import nus.iss.gdipsa.team7.repository.AccountRepository;
import nus.iss.gdipsa.team7.repository.BanRequestRepository;
import nus.iss.gdipsa.team7.repository.GamePostRepository;
import nus.iss.gdipsa.team7.repository.GameRepository;

@Service
public class DashboardServiceImpl implements DashboardService{

	@Autowired
	private AccountRepository accRepo;
	
	@Autowired
	private GameRepository gameRepo;
	
	@Autowired
	private GamePostRepository gamePostRepo;
	
	@Autowired
	private BanRequestRepository banRequestRepo;
	
	@Override
	public long getTotalGamers() {
		List<Account> all = accRepo.findAll();
		long count =0;
		for(Account cc:all){
			Role ccRole = cc.getRole();
			if(ccRole==Role.User){
				count++;
			}
		}
		System.out.println("---------------User:"+count);
		return count;
	}

	@Override
	public long getTotalDevelopers() {
		List<Account> all = accRepo.findAll();
		long count =0;
		for(Account cc:all) {
			Role ccRole = cc.getRole();
			if(ccRole==Role.Developer){
				count++;
			}
		}
		System.out.println("---------------Developer:"+count);
		return count;
	}

	@Override
	public long getTotalGames() {
		return gameRepo.count();
	}

	@Override
	public long getGamesPendingReview() {
		return gameRepo.countByPendingGames(GameStatus.Pending);
	}

	@Override
	public long getUserReports() {
		return banRequestRepo.count();
	}

	@Override
	public long getTotalAccountGame(String name) {
		Account account = accRepo.searchByName(name);
		List<Game> games = gameRepo.searchByGameNameOrDeveloperName(account.getUsername());
		System.out.println("------------------------------------------");
		System.out.println(games.size());
		System.out.println("------------------------------------------");
		return games.size();
	}

	@Override
	public double getAvgAccountGame(String name) {
		Account account = accRepo.searchByName(name);
		List<Game> games = gameRepo.searchByGameNameOrDeveloperName(account.getUsername());
		double sum_rating=0;
		for(Game game:games){
			sum_rating=sum_rating+game.getRating();
		}
		return sum_rating/games.size();
	}
}
