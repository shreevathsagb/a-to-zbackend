package com.example.demo;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Controller {
	
	@Autowired
	private ClassroomRepository classrepo;
	
	@Autowired
	private StudentRepositroy studentrepo;
	
	
	
	
	
	
	@PostMapping("/addclass")
	public ResponseEntity<?>add(@RequestBody ClassroomEntity obj ){
		classrepo.save(obj);
		return new ResponseEntity<>("Success" , HttpStatus.OK);
		
		
	}
	
	@PostMapping("/addstudent/{cid}")
    public ResponseEntity<?> addStudent(@RequestBody StudentEntity student, @PathVariable int cid) {
        ClassroomEntity classroom = classrepo.findById(cid).orElse(null);

        if (classroom != null) {
            student.setClassroom(classroom);
            System.out.println("Received student name: " + student.getStudentname());
            System.out.println("Received classroom ID (cid): " + cid);
            studentrepo.save(student);
            return new ResponseEntity<>("Student added successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Classroom not found", HttpStatus.NOT_FOUND);
        }
    }
	
	
	@GetMapping("/students/{cid}")
    public ResponseEntity<?> getStudentsByClass(@PathVariable int cid) {
        ClassroomEntity classroom = classrepo.findById(cid).orElse(null);

        if (classroom != null) {
            List <StudentEntity> students = classroom.getStudents();
            System.out.println("Number of students: " + students.size()); 
            return new ResponseEntity<>(students, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	
	
	
}
