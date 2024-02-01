package nus.iss.gdipsa.team7.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import nus.iss.gdipsa.team7.model.Game;
import nus.iss.gdipsa.team7.model.GameStatus;
import nus.iss.gdipsa.team7.repository.GameRepository;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	GameRepository gameRepo;

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
		// TODO Auto-generated method stub
		gameRepo.updateGameStatus(gameId, GameStatus.Approved);
	}

	@Override
	public void rejectGame(Integer gameId) {
		// TODO Auto-generated method stub
		gameRepo.updateGameStatus(gameId, GameStatus.Rejected);
	}

	@Override
	public List<Game> findByGameStatus(GameStatus gameStatus) {

		return gameRepo.findByGameStatus(gameStatus);
	}
}
