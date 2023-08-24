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

import com.sathish.ShoppingCart.Dto.CustomerDto;
import com.sathish.ShoppingCart.Helper.ResponseStructure;
import com.sathish.ShoppingCart.Service.CartService;
import com.sathish.ShoppingCart.Service.CustomerService;

@RestController
@RequestMapping("/customer")
public class Customer {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	CartService cartService;

	//Customer Signup
	@PostMapping("/signup")
	public ResponseStructure<CustomerDto> CreateCustomer(@RequestBody CustomerDto customerDto) {
		return customerService.CreateCustomer(customerDto);
	}
    
	//Customer ID fetching by customer ID
	@GetMapping("/fetch/{id}")
	public Object FetchCustomerById(@PathVariable int id) {
		return customerService.FetchCustomerById(id);
	}

	//Customer ID details Updating
	@PutMapping("/updatecustomer/{id}")
	public ResponseStructure<CustomerDto> UpdateCustomerById(@PathVariable int id, @RequestBody CustomerDto customerDto) {
		customerDto.setId(id);
		return customerService.UpdateCustomerById(customerDto);
	}
    
	//Customer ID deleting by Customer ID
	@DeleteMapping("/deletecustomer/{id}")
	public Object DeleteCustomerById(@PathVariable int id) {
		return customerService.DeleteCustomerById(id);
	}
	
	//Fetching all Customer ID's
	@GetMapping("/fetchallcustomer")
	public ResponseStructure<List<CustomerDto>> FetchAllCustomer() {
		return customerService.FetchAllCustomer();
	}
	
	//Customer Adding Products to their cart with quantity
	@PostMapping("/addcart/{customerid}/{productid}/{quantity}")
	public void CustomerAddProductsToCart( @PathVariable int customerid,@PathVariable int productid,@PathVariable int quantity) {
	   //CustomerDto customerDto= (CustomerDto) customerService.FetchCustomerById(customerid).get();
	   //customerService.CustomerAddProductsToCart(customerDto,productid,quantity);
	}
	
	public void AddItems() {

	}

}
