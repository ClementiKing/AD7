package nus.iss.gdipsa.team7.service;

public interface DashboardService {
	
	long getTotalGamers();
    long getTotalDevelopers();
    long getTotalGames();
    long getGamesPendingReview();
    long getUserReports();

    long getTotalAccountGame(String name);

    double getAvgAccountGame(String name);
}
