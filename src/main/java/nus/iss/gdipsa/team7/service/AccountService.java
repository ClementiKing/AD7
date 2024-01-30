package nus.iss.gdipsa.team7.service;

import nus.iss.gdipsa.team7.model.Account;

public interface AccountService {

	public Account authenticate(String username, String password);
}
