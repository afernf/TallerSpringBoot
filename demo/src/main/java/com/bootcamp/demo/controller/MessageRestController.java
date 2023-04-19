package com.bootcamp.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo.MessageServiceImpl;

@RestController
@RequestMapping(value = "/api/v1")
@Service
public class MessageRestController{
	
	@Autowired
	private MessageServiceImpl messageService;
	
	
	@GetMapping("/message")
    public String message() {
        return messageService.getMessage();
    }
	
	/*
	@GetMapping("/message")
    public String message() {
        return message;
    }
	*/
	
	/*
	@GetMapping("/message")
    public String message() {
        return "Hello World";
    }
    */
	
}
