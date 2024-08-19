package com.ofss.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ofss.main.domain.Customer;
import com.ofss.main.domain.Login;
import com.ofss.main.repository.CustomerRepository;
import com.ofss.main.repository.LoginRepository;
import com.ofss.main.service.CustomerService;
import com.ofss.main.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	LoginService loginService;
	@Autowired
	CustomerService customerService;
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	LoginRepository loginRepository;
	
	@GetMapping(path = "dis")
	//http://localhost:8083/login/signup
	public List<Login> DisplayList(){
		List<Login> logins = loginService.getAllLogins();
		return logins;
	}
	
	@GetMapping(path = "getone/{cid}")
	public Login GetOneById(@PathVariable int cid) {
		System.out.println(cid);
		Login login = loginService.getCustomerByLoginId(cid);
        System.out.println(login);
     	return login;
	}
	@CrossOrigin
	@PostMapping(path = "signin")
	public Login signIn(@RequestBody ObjectNode objectNode) {
		System.out.println("Data: " + objectNode);
		String custID = objectNode.get("customerId").asText();
		String password = objectNode.get("password").asText();
		int id = Integer.valueOf(custID);
		Login login = loginService.loginByIdAndPassword(id, password);
		return login;
	}
	
	@CrossOrigin
	@PostMapping(path = "signup")
	public Customer signUp(@RequestBody Customer customer) {
		Customer customer2 = customerRepository.save(customer);
		return customer2;
	}
	
	@CrossOrigin
	@PostMapping(path = "lsignup")
	public Login llsignup(@RequestBody ObjectNode objectNode) {
		String custID = objectNode.get("customerId").asText();
		String password = objectNode.get("password").asText();
		int id = Integer.valueOf(custID);
		Login login = new Login(id,password);
		Login ok = loginRepository.save(login);
		return ok;
	}
	
	
}
