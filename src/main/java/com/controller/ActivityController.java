package com.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("activity")
public class ActivityController {

	@RequestMapping("get")
	public String getActivity() {
		return "Activity Controller.";
	}

}