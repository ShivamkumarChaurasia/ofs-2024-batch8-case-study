package com.ofss.main;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ofss.main.domain.Customer;
import com.ofss.main.domain.Login;
import com.ofss.main.repository.CustomerRepository;
import com.ofss.main.repository.LoginRepository;

@SpringBootTest
class InternetBankingApplicationTests {
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	LoginRepository loginRepository;
	@Test
	void databaseTest() {
		Iterable<Customer> customers = customerRepository.findAll();
		for (Customer customer : customers) {
			System.out.println(customer);
		}
	}
	@Test
	void loginTest() {
		Iterable<Login> logins = loginRepository.findAll();
		for (Login login : logins) {
			System.out.println(login);
		}
	}
	
	
	@Test
	void CustById() {
		Optional<Customer> customer = customerRepository.findById(2222);
		System.out.println(customer);
	}
	
	@Test
	void LogById() {
		Optional<Login> customer = loginRepository.findById(2222);
		System.out.println(customer);
	}

}
