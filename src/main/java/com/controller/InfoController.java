package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("info")
public class InfoController {

	@RequestMapping("get")
	public String index() {
		return "Info Controller.";
	}

}
