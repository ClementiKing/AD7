package nus.iss.gdipsa.team7;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import nus.iss.gdipsa.team7.model.Account;
import nus.iss.gdipsa.team7.model.BanRequest;
import nus.iss.gdipsa.team7.model.Game;
import nus.iss.gdipsa.team7.model.GameStatus;
import nus.iss.gdipsa.team7.model.Role;
import nus.iss.gdipsa.team7.model.User;
import nus.iss.gdipsa.team7.repository.AccountRepository;
import nus.iss.gdipsa.team7.repository.BanRequestRepository;
import nus.iss.gdipsa.team7.repository.GameRepository;
import nus.iss.gdipsa.team7.repository.UserRepository;

@SpringBootApplication
public class AdProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdProjectApplication.class, args);
	}

	@Bean
	CommandLineRunner loadData(AccountRepository accRepo, UserRepository userRepo, GameRepository gameRepo, BanRequestRepository banRequestRepo)
	{
		return args -> {
			User team7Boss = new User(); 
			userRepo.save(team7Boss);

	        
	        Account team7BossAcc = new Account("team7Boss", "password", Role.Administrator);
	        team7BossAcc.setUser(team7Boss);
			accRepo.save(team7BossAcc);

	        
	        accRepo.save(new Account("team7Dev", "password", Role.Developer));
	        accRepo.save(new Account("team7Dev2", "password", Role.Developer));
	        accRepo.save(new Account("team7Dev3", "password", Role.Developer));
	        accRepo.save(new Account("team7Dev4", "password", Role.Developer));
	        
	        accRepo.save(new Account("YangHan", "password", Role.User));
	        accRepo.save(new Account("Brandon", "password", Role.User));
	        accRepo.save(new Account("HaiXj", "password", Role.User));
	        accRepo.save(new Account("Luke", "password", Role.User));
	        accRepo.save(new Account("Shiny", "password", Role.User));
	        accRepo.save(new Account("Diaz", "password", Role.User));
	        accRepo.save(new Account("Bolian", "password", Role.User));
	        
	        gameRepo.save(new Game("GTA1", "A nice game."));
	        gameRepo.save(new Game("GTA2", "A nice game."));
	        gameRepo.save(new Game("GTA3", "A nice game."));
	        gameRepo.save(new Game("GTA4", "A nice game."));
	        gameRepo.save(new Game("GTAV", "A nice game."));
			
	        banRequestRepo.save(new BanRequest());
		};
	}
}
