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
	@Override
	public List<Login> getAllLogins() {
		return (List<Login>) loginRepository.findAll();
	}

	@Override
	public Login getCustomerByLoginId(int Id) {
		Optional<Login> login = loginRepository.findById(Id);
		return login.orElse(null);
	}

}
