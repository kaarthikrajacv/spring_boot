package com.hello.world.demo.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class CricketCoach implements Coach {
	
	@PostConstruct
	public void printPostConstructData() {
		System.out.println("This is a post Construct method");
	}
	
	@PreDestroy
	public void printPreDestroyData() {
		System.out.println("This is a pre destroy method");
	}

	@Override
	public String giveWorkout() {
		
		return "Practice cricket daily";
		
		
	}

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		
		return "This is an awesome day fpr cricket";
	}

}
