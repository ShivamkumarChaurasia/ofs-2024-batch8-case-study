package com.ofss.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.main.domain.Customer;
import com.ofss.main.domain.Login;
import com.ofss.main.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@GetMapping(path = "dis")
	//http://localhost:8083/customer/dis
	public List<Login> DisplayList(){
		List<Login> logins = loginService.getAllLogins();
		return logins;
	}
	@GetMapping(path = "getone/{cid}")
	public Login GetOneById(@PathVariable int cid) {
//		System.out.println(cid);
		Login login = loginService.getCustomerByLoginId(cid);
//      System.out.println(customer);
     	return login;
	}
	
	@GetMapping(path = "signin")
	public String signIn() {
		return "";
	}
	
	@GetMapping(path = "signup")
	public String signUp() {
		return "";
	}
	
	
	
	
}
