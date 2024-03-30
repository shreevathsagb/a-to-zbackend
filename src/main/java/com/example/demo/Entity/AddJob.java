
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
public class AddJob {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String job;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	
	@OneToMany(mappedBy="addFreeJob")
	@JsonIgnore
	private List<FreelancerEntity> addJobfree;
	
	public List<FreelancerEntity> getAddJobfree() {
		return addJobfree;
	}
	public void setAddJobfree(List<FreelancerEntity> addJobfree) {
		this.addJobfree = addJobfree;
	}
}