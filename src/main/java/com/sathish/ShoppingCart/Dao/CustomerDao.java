package com.sathish.ShoppingCart.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sathish.ShoppingCart.Dto.CustomerDto;
import com.sathish.ShoppingCart.Repository.CustomerRepository;

@Repository
public class CustomerDao {

	@Autowired
	CustomerRepository customerRepository;

	public void CreateCustomer(CustomerDto customerDto) {
		customerRepository.save(customerDto);
	}

	public Optional<CustomerDto> FetchCustomerById(int id) {
		return customerRepository.findById(id);
	}

	public void UpdateCustomerById(CustomerDto customerDto) {
		customerRepository.save(customerDto);
	}

	public void DeleteCustomerById(int id) {
		customerRepository.deleteById(id);
	}

	public List<CustomerDto> FetchAllCustomer() {
		return customerRepository.findAll();
	}

	public void AddCart() {
        customerRepository.save(null);
	}

}
