package com.hello.world.demo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hello.world.demo.entity.StudentDTO;
import com.hello.world.demo.entity.StudentEntity;
import com.hello.world.demo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	
	@Autowired StudentService studentService;
	
	
	@GetMapping
	public List<StudentDTO> returnAllStudentList(){
		
		return studentService.getAllStudentsFromDB();
		
	}
	
	
	@PostMapping
	public void saveStudentDetails(@RequestBody StudentEntity student) {

		studentService.saveStudent(student);
	}
	
	
	@GetMapping("/{id}")
	public StudentEntity getStudentById(@PathVariable("id") Long id){
		
		return studentService.getStudentById(id);
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteStudentById(@PathVariable("id") Long id) {
		
		studentService.deleteById(id);
		
	}
	
	
}
