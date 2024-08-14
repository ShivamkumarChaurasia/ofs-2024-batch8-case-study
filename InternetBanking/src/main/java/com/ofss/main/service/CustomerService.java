package com.ofss.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ofss.main.domain.Customer;

@Service
public interface CustomerService {
	List<Customer> getAllCustomers();
	Customer getCustomerByCustomerId(int Id);
}
