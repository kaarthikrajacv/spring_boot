package com.hello.world.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hello.world.demo.service.Coach;

@RestController
@RequestMapping("/coach")
public class CoachController {
	
	@Autowired
	Coach baseBallCoach;
	
	@GetMapping("/baseball/workout")
	public String returnBaseballCoachWorkout() {
		
		System.out.println("The hashcode for Coach object is " + baseBallCoach.hashCode());
		
		String workout = baseBallCoach.giveWorkout();
		
		return workout;
		
		
	}

}
