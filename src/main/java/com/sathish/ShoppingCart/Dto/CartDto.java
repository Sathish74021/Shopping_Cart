package com.sathish.ShoppingCart.Dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Component
@Entity(name="Cart")
public class CartDto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;

	@OneToOne
	CustomerDto customerDto;

	@OneToMany
	List<ItemsDto> itemsDtos;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public CustomerDto getCustomerDto() {
		return customerDto;
	}

	public void setCustomerDto(CustomerDto customerDto) {
		this.customerDto = customerDto;
	}

	public List<ItemsDto> getItemsDtos() {
		return itemsDtos;
	}

	public void setItemsDtos(List<ItemsDto> itemsDtos) {
		this.itemsDtos = itemsDtos;
	}
	
}
