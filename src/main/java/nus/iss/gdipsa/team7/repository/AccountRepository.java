package nus.iss.gdipsa.team7.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import nus.iss.gdipsa.team7.model.Account;
import nus.iss.gdipsa.team7.model.Role;

public interface AccountRepository extends JpaRepository<Account, String> {
	
	@Query("SELECT acc FROM Account acc WHERE acc.username = :username AND acc.password = :password")
	public Account findAccountByUsernamePassword(@Param("username")String username, @Param("password")String password);
	
	@Query("SELECT COUNT(a) FROM Account a JOIN a.role r WHERE r IN :roles")
	public long countByRole(@Param("role") Role role);

	@Query("SELECT acc FROM Account acc WHERE acc.username LIKE %:name% AND acc.role = User or acc.displayName LIKE %:name% AND acc.role = User")
	public List<Account> SearchGamerByName(@Param("name") String name);
	
	@Query("SELECT acc FROM Account acc WHERE acc.username LIKE %:name% AND acc.role = Developer or acc.displayName LIKE %:name% AND acc.role = Developer")
	public List<Account> SearchDeveloperByName(@Param("name") String name);
}
