package com.ofss.main.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ofss.main.domain.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
//	public List<Customer> findAllcustomersDetails();
//	public Customer getCustomerByCustomerId(int customerId);
//	public boolean addNewCustomer(Customer customer);
//	public boolean checkCustomer(Customer customer);
}
