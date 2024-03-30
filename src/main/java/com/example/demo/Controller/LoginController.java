package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.Repository.AdminRepository;
import com.example.demo.Repository.CustomerRepository;
import com.example.demo.Repository.FreelancerRepository;

@RestController
@CrossOrigin("*")
public class LoginController {
    
    @Autowired
    private AdminRepository adminRepo;
    
    @Autowired
    private CustomerRepository customerRepo;
    
    @Autowired
    private FreelancerRepository freelancerRepo;
    
    @PostMapping("/loginVerify")
    public ResponseEntity<?> loginverify(@RequestBody LoginDTO obj) {
        if (obj.getUsertype().equals("Admin")) {
            var admin = adminRepo.findById(obj.getEmail()).orElseThrow(() -> new RuntimeException("Admin not found"));
            if (admin.getPassword().equals(obj.getPassword())) {
                return new ResponseEntity<>("Admin logged in Success", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Password Mismatched", HttpStatus.BAD_REQUEST);
            }
        } else if (obj.getUsertype().equals("Freelancer")) {
            var freelancer = freelancerRepo.findByEmail(obj.getEmail()).orElse(null);
            if (freelancer != null) {
                if (freelancer.getPassword().equals(obj.getPassword())) {
                    return new ResponseEntity<>("Freelancer logged in Successfully", HttpStatus.OK);
                } else {
                    return new ResponseEntity<>("Password Mismatched", HttpStatus.BAD_REQUEST);
                }
            } else {
                return new ResponseEntity<>("Freelancer Not Found", HttpStatus.NOT_FOUND);
            }
        } else if (obj.getUsertype().equals("Customer")) {
            var customer = customerRepo.findByEmail(obj.getEmail()).orElseThrow(() -> new RuntimeException("Customer Not Found"));
            if (customer.getPassword().equals(obj.getPassword())) {
                return new ResponseEntity<>("Customer Logged in success", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Password Mismatched", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("No one Found", HttpStatus.BAD_REQUEST);
        }
    }
}
