package com.hello.world.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hello.world.demo.entity.StudentEntity;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
	
	@Autowired SessionFactory sessionFactory;

	@Override
	public List<StudentEntity> getAllStudentDetails() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<StudentEntity> studentQuery = session.createQuery("from StudentEntity", StudentEntity.class);
		
		return studentQuery.getResultList();
	}

	@Override
	public void saveStudent(StudentEntity student) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(student);
		
	}

	@Override
	public StudentEntity getStudentByID(Long id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		return session.get(StudentEntity.class, id);
	}

	@Override
	public void deleteById(Long id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		StudentEntity student = session.get(StudentEntity.class, id);
		
		System.out.println("The student is " + student);
		
		session.delete(student);
		
		session.beginTransaction().commit();
		
	}

}
