package com.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.UserActivity;

@RestController
@RequestMapping("activity")
public class ActivityController {

	@RequestMapping(value = "get", method = RequestMethod.GET, produces = { "application/json" })
	public UserActivity getActivity() {
		UserActivity activity = new UserActivity("Running", 20L);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();

		System.out.println("Logged in user name : " + name);
		System.out.println(auth.getAuthorities());
		return activity;
	}
}
