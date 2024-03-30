package com.example.demo.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AddCity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String city;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	

	@OneToMany(mappedBy = "addFreeCity")
	@JsonIgnore
	private List<FreelancerEntity> addCityFree;
	public List<FreelancerEntity> getAddCityFree() {
		return addCityFree;
	}
	public void setAddCityFree(List<FreelancerEntity> addCityFree) {
		this.addCityFree = addCityFree;
	}

	
	
	
	
	
}
