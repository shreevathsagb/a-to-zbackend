package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.AddJob;
import com.example.demo.Repository.AddJobRepository;

@RestController
@CrossOrigin("*")
public class JobController {
	
	@Autowired
	private AddJobRepository jobRepo;
	
	@PostMapping("/addJob")
	public ResponseEntity<?>addJob(@RequestBody AddJob obj){
		if (jobRepo.existsByJob(obj.getJob())){
			return new ResponseEntity<>("Job already exists" , HttpStatus.BAD_REQUEST);
		}
		else {
			jobRepo.save(obj);
			return new ResponseEntity<>("Job Added Succesfully" ,HttpStatus.OK);
		}
	}
	
	
	@GetMapping("/getJob")
	public ResponseEntity<?>getJob(){
		List<AddJob> data = jobRepo.findAll();
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

}
