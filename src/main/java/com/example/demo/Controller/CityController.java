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

import com.example.demo.Entity.AddCity;
import com.example.demo.Repository.AddCityRepository;

@RestController
@CrossOrigin("*")
public class CityController {
	
	
	@Autowired
	private AddCityRepository cityrepo;
	
	
	@PostMapping("/addCity")
	public ResponseEntity<?> addCity(@RequestBody AddCity obj){
		if (cityrepo.existsByCity(obj.getCity())){
			return new ResponseEntity<>("City already exists" , HttpStatus.BAD_REQUEST);
		}
		else {
			cityrepo.save(obj);
			return new ResponseEntity<>("City Added Succesfully" ,HttpStatus.OK);
		}
	
	}
	
	
	@GetMapping("/getCity")
	public ResponseEntity<?> getCity(){
		var data = cityrepo.findAll();
		return new ResponseEntity<>(data,HttpStatus.OK);
		
	}

}
