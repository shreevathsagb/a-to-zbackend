package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.CustomerEntity;
import com.example.demo.Repository.CustomerRepository;

@RestController
@CrossOrigin("*")
public class CustomerController {
	
	
	@Autowired
	public CustomerRepository customerRepo;
	
	
	@PostMapping("/AddCustomer")
	public ResponseEntity<?>addCustomer(@RequestBody CustomerEntity obj){
		if (customerRepo.existsByEmail(obj.getEmail())){
			return new ResponseEntity<>("Email Already Exists" , HttpStatus.BAD_REQUEST);
		}
		else {
			customerRepo.save(obj);
			return new ResponseEntity<>("Customer Registerd Succesfully", HttpStatus.OK);
		}
	}
}
