package com.herokuapp.interhack2019.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/")
	public String hello() {
		return "index";
	}
	@RequestMapping("/fim")
	public String fim(){
		return "fim";
	}

}

