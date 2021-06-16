package com.hello.world.demo.entity;

public class TestInstructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InstrucorDetailsEntity ins = new InstrucorDetailsEntity(11l, "My channel", "coding");
		
		/// ins save to DB ...
		
		InstructorEntity instructor = new InstructorEntity(45l, "abc", "xzy", "abc.xyz@gmail.com", ins);
		
		//instructor save in DB ...

	}

}
