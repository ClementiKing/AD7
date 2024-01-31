package nus.iss.gdipsa.team7.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import nus.iss.gdipsa.team7.model.Account;
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
		return gamePostRepo.count();
	}

	@Override
	public long getUserReports() {
		return banRequestRepo.count();
	}

}
