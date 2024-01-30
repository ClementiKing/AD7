package nus.iss.gdipsa.team7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nus.iss.gdipsa.team7.model.Account;
import nus.iss.gdipsa.team7.repository.AccountRepository;

@Service
@Transactional(readOnly = true)
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountRepository accRepo;

	@Override
	public Account authenticate(String username, String password) {
		return accRepo.findAccountByUsernamePassword(username, password);
	}

}
