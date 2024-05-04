package com.simple.helloworld.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simple.helloworld.HelloWorld;

@RestController
public class HelloWorldController {
	private final static String template="Hello %s.";
	private final AtomicLong contador= new AtomicLong();
	
	//Retorna uma String Hello World
	@GetMapping("/")
	public String hello() 
	{
	     return "Hello World";
	}
	//Retorna um json 
	//{
	 // id:
	// Mensagem:Hello + String
	//}
	@GetMapping ("/hello")
	public HelloWorld hello (@RequestParam(value = "name", defaultValue="World")String name) {
		return new HelloWorld(contador.incrementAndGet(), String.format(template, name));

	}
	
}

