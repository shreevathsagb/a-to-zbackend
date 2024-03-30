package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
public class FreelancerEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String email;
	private String password;
	private String mobile;
	private String address;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	
	@ManyToOne
	@JoinColumn(name="cid")
	private AddCity addFreeCity;
	
	
	
	public AddCity getAddFreeCity() {
		return addFreeCity;
	}
	public void setAddFreeCity(AddCity addFreeCity) {
		this.addFreeCity = addFreeCity;
	}
	
	
	@ManyToOne
	@JoinColumn(name="jid")
	private AddJob addFreeJob;
	public AddJob getAddFreeJob() {
		return addFreeJob;
	}
	public void setAddFreeJob(AddJob addFreeJob) {
		this.addFreeJob = addFreeJob;
	}
	public String getJob() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
