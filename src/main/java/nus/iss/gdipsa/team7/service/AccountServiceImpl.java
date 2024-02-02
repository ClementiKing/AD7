package nus.iss.gdipsa.team7.service;

import nus.iss.gdipsa.team7.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nus.iss.gdipsa.team7.model.Account;
import nus.iss.gdipsa.team7.repository.AccountRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountRepository accRepo;

	@Override
	public Account authenticate(String username, String password) {
		return accRepo.findAccountByUsernamePassword(username, password);
	}

	@Override
	public List<Account> findByRoles(Role role) {
		List<Account> accounts=new ArrayList<>();
		List<Account> all = accRepo.findAll();
		for(Account cc:all){
			Role ccRole = cc.getRole();
			if(ccRole==role){
				accounts.add(cc);
			}
		}
		return accounts;
	}

}
