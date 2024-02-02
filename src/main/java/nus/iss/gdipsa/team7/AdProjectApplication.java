package nus.iss.gdipsa.team7;

import java.util.ArrayList;
import java.util.List;

import nus.iss.gdipsa.team7.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import nus.iss.gdipsa.team7.model.Account;
import nus.iss.gdipsa.team7.model.BanRequest;
import nus.iss.gdipsa.team7.model.Game;
import nus.iss.gdipsa.team7.model.GameStatus;
import nus.iss.gdipsa.team7.model.Genre;
import nus.iss.gdipsa.team7.model.Role;
import nus.iss.gdipsa.team7.model.User;

@SpringBootApplication
public class AdProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdProjectApplication.class, args);
	}

	@Bean
	CommandLineRunner loadData(AccountRepository accRepo, GenreRepository greRepo, UserRepository userRepo, GameRepository gameRepo, BanRequestRepository banRequestRepo)
	{
		return args -> {
			User team7Boss = new User("0",true); 
			userRepo.save(team7Boss);

	        
	        Account team7BossAcc = new Account("team7Boss", "password", Role.Administrator);
	        team7BossAcc.setUser(team7Boss);
			accRepo.save(team7BossAcc);

			Account acc1 = new Account("team7Dev", "password", Role.Developer);
			Account acc2 = new Account("team7Dev2", "password", Role.Developer);
			User d1=new User("1",true);
			User d2=new User("2",true);
			User u3=new User("3",true);
			User u4=new User("4",true);
			User u5=new User("5",true);
			User u6=new User("6",true);
			User u7=new User("7",true);
			User u8=new User("8",true);
			User u9=new User("9",true);

			userRepo.save(d1);
			userRepo.save(d2);
			userRepo.save(u3);
			userRepo.save(u4);
			userRepo.save(u5);
			userRepo.save(u6);
			userRepo.save(u7);
			userRepo.save(u8);
			userRepo.save(u9);

			acc1.setUser(d1);
			acc2.setUser(d2);
			accRepo.save(acc1);
			accRepo.save(acc2);

			Account acc_developer_1 = new Account("team7Dev3", "password", Role.Developer,"Xun");
			Account acc_developer_2 = new Account("team7Dev4", "password", Role.Developer,"Tom");
			User d3=new User("12",true);
			User d4=new User("123",true);
			
			userRepo.save(d3);
			userRepo.save(d4);
			
			acc_developer_1.setUser(d3);
			acc_developer_2.setUser(d4);

			
			accRepo.save(acc_developer_1);
			accRepo.save(acc_developer_2);



			Account acc_user_1 = new Account("YangHan", "password", Role.User,"TiNa");
			Account acc_user_2 = new Account("Brandon", "password", Role.User,"Yang");
			Account acc_user_3 = new Account("HaiXj", "password", Role.User,"Saxx");
			Account acc_user_4 = new Account("Luke", "password", Role.User,"Rshq");
			Account acc_user_5 = new Account("Shiny", "password", Role.User,"drikn");
			Account acc_user_6 = new Account("Diaz", "password", Role.User,"wu");
			Account acc_user_7 = new Account("Bolian", "password", Role.User,"Xi");
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

	        List<Genre> gen = new ArrayList<>();
			Genre w1 = new Genre("Open world");
			Genre w2 = new Genre("SASA world");
			gen.add(w2);
			gen.add(w1);
			greRepo.save(w2);
			greRepo.save(w1);
			Game game = new Game("GTA1", "A nice game.", acc1, gen);
			System.out.println("-------------------------------------");
			System.out.println(game);
			System.out.println("-------------------------------------");
			gameRepo.save(game);
	        gameRepo.save(new Game("GTA2", "A nice game.",acc1,gen));
	        gameRepo.save(new Game("GTA3", "A nice game.",acc2,gen));
	        gameRepo.save(new Game("GTA4", "A nice game.",acc2,gen));
	        gameRepo.save(new Game("GTAV", "A nice game.",acc1,gen));
			
	        banRequestRepo.save(new BanRequest());
		};
	}
}
