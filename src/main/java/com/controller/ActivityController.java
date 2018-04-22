package com.controller;

import org.springframework.http.MediaType;
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
		return activity;
	}

	@RequestMapping(value = "get", method = RequestMethod.POST, produces = { "application/json" })
	public UserActivity getActivityPost() {
		UserActivity activity = new UserActivity("Running", 20L);
		return activity;
	}
}