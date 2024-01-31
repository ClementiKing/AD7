package nus.iss.gdipsa.team7.service;

import java.util.List;
import java.util.Optional;

import nus.iss.gdipsa.team7.model.Game;

public interface GameService {
	
	public List<Game> findTop10ByRating();
	public List<Game> findAllGames();
	public List<Game> searchGames(String query);
	public Optional<Game> findGameById(Integer gameId);
	public void save(Game game);
	public List<Game> findByIsApprovedFalse();
	public void approveGame(Integer gameId);
	public void rejectGame(Integer gameId);
}
