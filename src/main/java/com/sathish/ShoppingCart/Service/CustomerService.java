package com.sathish.ShoppingCart.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathish.ShoppingCart.Dao.CustomerDao;
import com.sathish.ShoppingCart.Dto.CartDto;
import com.sathish.ShoppingCart.Dto.CustomerDto;

@Service
public class CustomerService {

	@Autowired
	CustomerDao customerDao;

	public String CreateCustomer(CustomerDto customerDto) {
		customerDao.CreateCustomer(customerDto);
		return "Created Customer ";
	}

	public Optional<CustomerDto> FetchCustomerById(int id) {
		return customerDao.FetchCustomerById(id);
	}

	public String UpdateCustomerById(CustomerDto customerDto) {
		customerDao.UpdateCustomerById(customerDto);
		return "Updated Customer";
	}

	public String DeleteCustomerById(int id) {
		customerDao.DeleteCustomerById(id);
		return "Customer Id Deleted";
	}

	public List<CustomerDto> FetchAllCustomer() {
		return customerDao.FetchAllCustomer();
	}
	
	public void CustomerAddToCart(CartDto cartDto,int customerid) {
		CustomerDto customerDto=customerDao.FetchCustomerById(customerid).get();
		
		
	}

}
