package com.hello.world.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.world.demo.entity.StudentDTO;
import com.hello.world.demo.entity.StudentEntity;
import com.hello.world.demo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired StudentRepository studentRepository;

	@Override
	public List<StudentDTO> getAllStudentsFromDB() {
		
		List<StudentEntity>  studentEntities = studentRepository.getAllStudentDetails();
		
		List<StudentDTO> students = new ArrayList<>();
		
		
		for(StudentEntity se : studentEntities) {
			
			
			String fullName = se.getFirstName() + " " + se.getLastName();
			
			String email = se.getEmail();
			
			students.add(new StudentDTO(fullName, email));
			
		}
		
		return students;
	}

	@Override
	public void saveStudent(StudentEntity student) {
		
		studentRepository.saveStudent(student);
		
		
	}

	@Override
	public StudentEntity getStudentById(Long id) {
		// TODO Auto-generated method stub
		return studentRepository.getStudentByID(id);
	}

	@Override
	public void deleteById(Long id) {
		
		studentRepository.deleteById(id);
	}

}
