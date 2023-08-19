package com.sathish.ShoppingCart.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sathish.ShoppingCart.Dto.CartDto;
import com.sathish.ShoppingCart.Dto.CustomerDto;
import com.sathish.ShoppingCart.Service.CartService;
import com.sathish.ShoppingCart.Service.CustomerService;

@RestController
@RequestMapping("/customer")
public class Customer {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	CartService cartService;

	@PostMapping("/signup")
	public String CreateCustomer(@RequestBody CustomerDto customerDto) {
		return customerService.CreateCustomer(customerDto);
	}

	@GetMapping("/fetch/{id}")
	public Object FetchCustomerById(@PathVariable int id) {
		return customerService.FetchCustomerById(id);
	}

	@PutMapping("/updatecustomer/{id}")
	public String UpdateCustomerById(@PathVariable int id, @RequestBody CustomerDto customerDto) {
		customerDto.setId(id);
		return customerService.UpdateCustomerById(customerDto);
	}

	@DeleteMapping("/deletecustomer/{id}")
	public String DeleteCustomerById(@PathVariable int id) {
		return customerService.DeleteCustomerById(id);
	}
	
	@GetMapping("/fetchallcustomer")
	public List<CustomerDto> FetchAllCustomer() {
		return customerService.FetchAllCustomer();
	}
	
	@PostMapping("/addcart/{customerid}")
	public void AddCart(@RequestBody CartDto cartDto, @PathVariable int customerid) {
	  customerService.CustomerAddToCart(cartDto,customerid);
      
	}
	
	public void AddItems() {

	}

}
