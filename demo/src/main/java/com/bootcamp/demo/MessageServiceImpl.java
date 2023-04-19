package com.bootcamp.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService{
	
	@Value("${course.message}")
	private String message;
	
	public String getMessage() {
		return message;
	}

}
