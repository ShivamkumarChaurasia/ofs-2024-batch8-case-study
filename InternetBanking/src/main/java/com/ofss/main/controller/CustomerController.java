package com.ofss.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.main.domain.Customer;
import com.ofss.main.repository.CustomerRepository;
import com.ofss.main.service.CustomerService;

@RestController
@RequestMapping("/customer")
//http://localhost:8083/customer
public class CustomerController {
	@Autowired
	CustomerService customerService;
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
}
