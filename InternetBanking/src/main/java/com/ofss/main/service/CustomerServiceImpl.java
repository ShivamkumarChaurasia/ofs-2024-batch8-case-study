package com.ofss.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.main.domain.Customer;
import com.ofss.main.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	@Override
	public List<Customer> getAllCustomers() {
		return (List<Customer>) customerRepository.findAll();
	}

	@Override
	public Customer getCustomerByCustomerId(int Id) {
		Optional<Customer> customer = customerRepository.findById(Id);
		return customer.orElse(null);
	}
	
	

}
