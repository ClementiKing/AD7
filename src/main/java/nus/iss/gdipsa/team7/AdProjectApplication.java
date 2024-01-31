package nus.iss.gdipsa.team7;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import nus.iss.gdipsa.team7.model.Account;
import nus.iss.gdipsa.team7.model.Role;
import nus.iss.gdipsa.team7.model.User;
import nus.iss.gdipsa.team7.repository.AccountRepository;
import nus.iss.gdipsa.team7.repository.UserRepository;

@SpringBootApplication
public class AdProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdProjectApplication.class, args);
	}

	@Bean
	CommandLineRunner loadData(AccountRepository accRepo, UserRepository userRepo)
	{
		return args -> {
			User team7Boss = new User(); 
			userRepo.save(team7Boss);
			
			List<Role> adminRole = new ArrayList<>();
	        adminRole.add(Role.Administrator);
	        
	        Account team7BossAcc = new Account("team7Boss", "password", adminRole);
	        team7BossAcc.setUser(team7Boss);
			accRepo.save(team7BossAcc);
			
			List<Role> devRole = new ArrayList<>();
	        devRole.add(Role.Developer);
	        
	        accRepo.save(new Account("team7Dev", "password", devRole));
			
		};
	}
}
