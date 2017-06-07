package fr.epita.basnet.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Address {

	@Id
	private int Id;
	private String City;
	private String Street;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public Address(int id, String city, String street) {
		super();
		Id = id;
		City = city;
		Street = street;
	}
	public Address(){
		
	}
}
