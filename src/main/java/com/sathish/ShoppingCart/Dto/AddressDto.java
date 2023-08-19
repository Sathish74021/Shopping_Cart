package com.sathish.ShoppingCart.Dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity(name="Address")
public class AddressDto {

	@Id
	private long phone_number;
	private String name;
	private String door_number;
	private String area;
	private int pin_code;
	public long getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDoor_number() {
		return door_number;
	}
	public void setDoor_number(String door_number) {
		this.door_number = door_number;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getPin_code() {
		return pin_code;
	}
	public void setPin_code(int pin_code) {
		this.pin_code = pin_code;
	}
	
}
