package nus.iss.gdipsa.team7.service;

import nus.iss.gdipsa.team7.model.Account;
import nus.iss.gdipsa.team7.model.Game;
import nus.iss.gdipsa.team7.model.Role;

import java.util.Collection;
import java.util.List;

public interface AccountService {

	public Account authenticate(String username, String password);

	public List<Account> findByRoles(Role role);

	public List<Account> searchGamerByName(String query);
	
	public List<Account> searchDeveloperByName(String query);
}
