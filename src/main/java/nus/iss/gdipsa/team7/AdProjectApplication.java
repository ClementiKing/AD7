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

			Account acc1 = new Account("team7Dev", "password", Role.Developer);
			Account acc2 = new Account("team7Dev2", "password", Role.Developer);
			User u1=new User("0000",true);
			User u2=new User("222",true);
			User u3=new User("222",true);
			User u4=new User("222",true);
			User u5=new User("222",true);
			User u6=new User("222",true);
			User u7=new User("222",true);
			User u8=new User("222",true);
			User u9=new User("222",true);

			userRepo.save(u1);
			userRepo.save(u2);
			userRepo.save(u3);
			userRepo.save(u4);
			userRepo.save(u5);
			userRepo.save(u6);
			userRepo.save(u7);
			userRepo.save(u8);
			userRepo.save(u9);

			acc1.setUser(u1);
			acc2.setUser(u2);
			accRepo.save(acc1);
			accRepo.save(acc2);

			accRepo.save(new Account("team7Dev3", "password", Role.Developer));
			accRepo.save(new Account("team7Dev4", "password", Role.Developer));



			Account acc_user_1 = new Account("YangHan", "password", Role.User);
			Account acc_user_2 = new Account("Brandon", "password", Role.User);
			Account acc_user_3 = new Account("HaiXj", "password", Role.User);
			Account acc_user_4 = new Account("Luke", "password", Role.User);
			Account acc_user_5 = new Account("Shiny", "password", Role.User);
			Account acc_user_6 = new Account("Diaz", "password", Role.User);
			Account acc_user_7 = new Account("Bolian", "password", Role.User);
			acc_user_1.setUser(u3);
			acc_user_2.setUser(u4);
			acc_user_3.setUser(u5);
			acc_user_4.setUser(u6);
			acc_user_5.setUser(u7);
			acc_user_6.setUser(u8);
			acc_user_7.setUser(u9);

			accRepo.save(acc_user_1);
			accRepo.save(acc_user_2);
			accRepo.save(acc_user_3);
			accRepo.save(acc_user_4);
			accRepo.save(acc_user_5);
			accRepo.save(acc_user_6);
			accRepo.save(acc_user_7);

	        
	        gameRepo.save(new Game("GTA1", "A nice game.",acc1));
	        gameRepo.save(new Game("GTA2", "A nice game.",acc1));
	        gameRepo.save(new Game("GTA3", "A nice game.",acc2));
	        gameRepo.save(new Game("GTA4", "A nice game.",acc2));
	        gameRepo.save(new Game("GTAV", "A nice game.",acc1));
			
	        banRequestRepo.save(new BanRequest());
		};
	}
}
