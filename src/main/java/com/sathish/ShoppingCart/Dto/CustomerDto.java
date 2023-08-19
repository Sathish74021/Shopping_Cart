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
@Entity(name="Customer")
public class CustomerDto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String email_id;
	private long phone_number;
	private String password;
	
	@OneToOne
	private CartDto cartDto;
	
	@OneToMany
	private List<AddressDto> addressDtos;
	
	@OneToMany
	private List<WishListDto> wishListDtos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public long getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}

	public CartDto getCartDto() {
		return cartDto;
	}

	public void setCartDto(CartDto cartDto) {
		this.cartDto = cartDto;
	}

	public List<AddressDto> getAddressDtos() {
		return addressDtos;
	}

	public void setAddressDtos(List<AddressDto> addressDtos) {
		this.addressDtos = addressDtos;
	}

	public List<WishListDto> getWishListDtos() {
		return wishListDtos;
	}

	public void setWishListDtos(List<WishListDto> wishListDtos) {
		this.wishListDtos = wishListDtos;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
}
