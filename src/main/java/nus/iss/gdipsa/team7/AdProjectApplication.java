package nus.iss.gdipsa.team7;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import nus.iss.gdipsa.team7.model.Account;
import nus.iss.gdipsa.team7.model.Role;
import nus.iss.gdipsa.team7.repository.AccountRepository;

@SpringBootApplication
public class AdProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdProjectApplication.class, args);
	}

	@Bean
	CommandLineRunner loadData(AccountRepository accRepo)
	{
		return args -> {
			
			List<Role> adminRole = new ArrayList<>();
	        adminRole.add(Role.Administrator);
	        
			accRepo.save(new Account("team7Boss", "password", adminRole));
		};
	}
}
