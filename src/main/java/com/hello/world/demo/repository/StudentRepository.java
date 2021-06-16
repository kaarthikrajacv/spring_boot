package com.hello.world.demo.repository;

import java.util.List;

import com.hello.world.demo.entity.StudentEntity;

public interface StudentRepository {
	
	public List<StudentEntity> getAllStudentDetails();
	
	public void saveStudent(StudentEntity student);
	
	public StudentEntity getStudentByID(Long id);
	
	public void deleteById(Long id);

}
