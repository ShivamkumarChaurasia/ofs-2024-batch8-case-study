package com.ofss.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ofss.main.domain.Login;



@Service
public interface LoginService {
	List<Login> getAllLogins();
	Login getCustomerByLoginId(int Id);
}
