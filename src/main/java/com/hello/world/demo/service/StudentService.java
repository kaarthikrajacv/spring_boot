package com.hello.world.demo.service;

import java.util.List;

import com.hello.world.demo.entity.StudentDTO;
import com.hello.world.demo.entity.StudentEntity;

public interface StudentService {
	
	public List<StudentDTO> getAllStudentsFromDB();
	
	public void saveStudent(StudentEntity student);
	
	public StudentEntity getStudentById(Long id);
	
	public void deleteById(Long id);

}
