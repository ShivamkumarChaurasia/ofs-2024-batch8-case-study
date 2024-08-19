package com.ofss.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.main.domain.Login;
import com.ofss.main.repository.LoginRepository;


@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginRepository loginRepository;
	@Autowired 
	CustomerService customerService;
	@Override
	public List<Login> getAllLogins() {
		return (List<Login>) loginRepository.findAll();
	}

	@Override
	public Login getCustomerByLoginId(int Id) {
		Optional<Login> login = loginRepository.findById(Id);
		return login.orElse(null);
	}

	@Override
	public Login loginByIdAndPassword(int id, String password) {
		Optional<Login> llogin = loginRepository.findById(id);
	    Login login = llogin.orElse(null);
	    Login temp = new Login(0);
	    Login retry = new Login(1);
		if(login != null && login.getCustomerId() == id && login.getUserPassword().equals(password)) {
			//set tries = 0
			//set active
			login.setTries(0); 
			login.setIsLocked(0);
			login.setStatus("Active");
 			loginRepository.save(login);
			return login;
		}
		if(login.getTries() >= 3) {
			//Block the account 
			login.setIsLocked(1);
			login.setStatus("Inactive");
			loginRepository.save(login);
			return temp;
		}
		login.setTries(login.getTries() + 1);
		loginRepository.save(login);
		return retry;
	}
	
	
	
//	@Override
//	public Login loginByIdAndPassword(String id, String password) {
//		Login login = loginRepository.findById(id);
//	}

}
