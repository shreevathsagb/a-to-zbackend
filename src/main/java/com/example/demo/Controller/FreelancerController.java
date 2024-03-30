package com.example.demo.Controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.FreelancerEntity;
import com.example.demo.Repository.AddCityRepository;
import com.example.demo.Repository.AddJobRepository;
import com.example.demo.Repository.FreelancerRepository;

@RestController
@CrossOrigin("*")
public class FreelancerController {
	
	
	@Autowired
	public FreelancerRepository frRepo;
	
	@Autowired
	public AddJobRepository addJobRepo;
	
	@Autowired
	public AddCityRepository addCityRepo;
	
	
	
	@PostMapping("/AddFreelancer/{jobid}/{cityid}")
	public ResponseEntity<?>addFreelancer(@RequestBody FreelancerEntity obj,@PathVariable int jobid,@PathVariable int cityid){
		if (frRepo.existsByEmail(obj.getEmail())) {
			return  new ResponseEntity<>("Email Already Exists",HttpStatus.BAD_REQUEST);
		}
		else {
			var jobs=addJobRepo.findById(jobid).orElseThrow(()->new RuntimeException("Job not found"));
			var cities=addCityRepo.findById(cityid).orElseThrow(()->new RuntimeException("City not found"));
			Random random = new Random();
			int randnumber = random.nextInt(9000)+1000;
			obj.setPassword((String.valueOf(randnumber)));
			obj.setAddFreeJob(jobs);
			obj.setAddFreeCity(cities);
			frRepo.save(obj);
			return new ResponseEntity<>("Freelanacer added Successfully",HttpStatus.OK);
		}

			

			
	}
	
	
	@GetMapping("/GetFreelancer")
	public ResponseEntity<?>getFreelancer(){
		List<FreelancerEntity> data=frRepo.findAll();
		return new ResponseEntity<>(data,HttpStatus.OK);
		
	}
	
}
