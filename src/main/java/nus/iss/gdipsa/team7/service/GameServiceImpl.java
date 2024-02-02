package nus.iss.gdipsa.team7.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import nus.iss.gdipsa.team7.model.*;
import nus.iss.gdipsa.team7.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import nus.iss.gdipsa.team7.repository.GameRepository;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	GameRepository gameRepo;
	@Autowired
	NotificationRepository ntRepo;

	@Override
	public List<Game> findTop10ByRating() {
		
		return gameRepo.findTop10Games(PageRequest.of(0, 10));
	}

	@Override
	public List<Game> findAllGames() {
		return gameRepo.findAll();
	}

	@Override
	public List<Game> searchGames(String query) {
		return gameRepo.findByTitle(query);
	}

	@Override
	public Optional<Game> findGameById(Integer Id) {
		return gameRepo.findById(Id);
	}

	@Override
	public void save(Game game) {
		gameRepo.save(game);
	}


	@Override
	public void approveGame(Integer gameId) {
		gameRepo.updateGameStatus(gameId, GameStatus.Approved);
		Optional<Game> repo = gameRepo.findById(gameId);
		Game game=repo.get();
		Account developer = game.getDeveloper();
		User user = developer.getUser();
		Notification nt = new Notification("Your game has been approved", "Your game application has been approved. Congratulations to you.", NotificationType.GameApproved, user);
		ntRepo.save(nt);
	}

	@Override
	public void rejectGame(Integer gameId) {
		// TODO Auto-generated method stub
		gameRepo.updateGameStatus(gameId, GameStatus.Rejected);
		Optional<Game> repo = gameRepo.findById(gameId);
		Game game=repo.get();
		Account developer = game.getDeveloper();
		User user = developer.getUser();
		Notification nt = new Notification("Your game has been rejected", "Your game application has been rejected, please revise it and submit it for review.", NotificationType.GameRejected, user);
		ntRepo.save(nt);
	}

	@Override
	public List<Game> findByGameStatus(GameStatus gameStatus) {

		return gameRepo.findByGameStatus(gameStatus);
	}

	@Override
	public List<Game> searchGamesByTerm(String searchTerm) {
		return gameRepo.searchByGameNameOrDeveloperName(searchTerm);
	}
	
}
