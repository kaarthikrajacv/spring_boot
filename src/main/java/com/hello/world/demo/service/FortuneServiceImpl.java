package com.hello.world.demo.service;

import org.springframework.stereotype.Service;

@Service
public class FortuneServiceImpl implements FortuneService {

	@Override
	public String getFortune() {
		
		
		return "This day is good for both baseball and cricket";
		
	}

	
	

}
