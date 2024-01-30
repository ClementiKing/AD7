package nus.iss.gdipsa.team7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import nus.iss.gdipsa.team7.model.Account;

public interface AccountRepository extends JpaRepository<Account, String> {
	
	@Query("SELECT acc FROM Account acc WHERE acc.username = :username AND acc.password = :password")
	public Account findAccountByUsernamePassword(@Param("username")String username, @Param("password")String password);

}
