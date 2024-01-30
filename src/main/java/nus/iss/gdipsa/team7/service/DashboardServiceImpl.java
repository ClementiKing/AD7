package nus.iss.gdipsa.team7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nus.iss.gdipsa.team7.repository.AccountRepository;

@Service
public class DashboardServiceImpl implements DashboardService{

	@Autowired
	AccountRepository accRepo;
	@Override
	public long getTotalGamers() {
		// TODO Auto-generated method stub
		return accRepo.count();
	}

	@Override
	public int getTotalDevelopers() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalGames() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getGamesPendingReview() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getUserReports() {
		// TODO Auto-generated method stub
		return 0;
	}

}
