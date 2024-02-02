package nus.iss.gdipsa.team7.service;

import nus.iss.gdipsa.team7.model.Account;
import nus.iss.gdipsa.team7.model.Role;

import java.util.List;

public interface AccountService {

	public Account authenticate(String username, String password);

	public List<Account> findByRoles(Role role);
}
