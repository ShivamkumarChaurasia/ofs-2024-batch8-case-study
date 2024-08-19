package com.ofss.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.main.domain.Customer;
import com.ofss.main.domain.Login;
import com.ofss.main.repository.CustomerRepository;
import com.ofss.main.repository.LoginRepository;
import com.ofss.main.service.CustomerService;
import com.ofss.main.service.LoginService;

@RestController
@RequestMapping("/customer")
//http://localhost:8083/customer
public class CustomerController {
	@Autowired
	CustomerService customerService;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	LoginService loginService;
	
	@Autowired
	LoginRepository loginRepository;
	
	@GetMapping(path = "dis")
	//http://localhost:8083/customer/dis
	public List<Customer> DisplayList(){
		List<Customer> customers = customerService.getAllCustomers();
		return customers;
	}
	
	@GetMapping(path = "getone/{cid}")
	public Customer GetOneById(@PathVariable int cid) {
//		System.out.println(cid);
		Customer customer = customerService.getCustomerByCustomerId(cid);
//      System.out.println(customer);
     	return customer;
	}
	
	
	@DeleteMapping(path = "del/{cid}")
	public boolean DeleteCustomer(@PathVariable int cid) {
		Customer ok = customerService.getCustomerByCustomerId(cid);
		customerRepository.delete(ok);
		Customer ok1 = customerService.getCustomerByCustomerId(cid);
		Optional<Login> lo = loginRepository.findById(cid);
		Login log = lo.orElse(null);
		if(log == null) {
			return false;
		}
		loginRepository.delete(log);
		if(ok1 == null) {
			return true;
		}
		return false;
	}
	
	
	
	
}
