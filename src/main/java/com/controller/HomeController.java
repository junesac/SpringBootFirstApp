package com.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/home")
public class HomeController {

	@RequestMapping("/get")
	public String getHome() {
		return "Home Controller.";
	}

}
