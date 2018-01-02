package com.andela.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.andela.model.Activity;
import com.andela.model.Exercise;

@Controller
public class MinutesController {
	
	@RequestMapping(value = "/addMinutes")
	public String addMinutes(@ModelAttribute ("exercise") Exercise exercise) {
		
		System.out.println("Exercise: " + exercise.getMinutes());
//		return "forward:addMoreMinutes.html";
		return "addMinutes";
	}
	
//	@RequestMapping(value = "/addMoreMinutes")
//	public String addMoreMinutes(@ModelAttribute ("exercise") Exercise exercise) {
//		
//		System.out.println("addMoreMinutes: " + exercise.getMinutes());
//		return "addMinutes";
//	}
	
	@RequestMapping(value="/activitues", method = RequestMethod.GET)
	public @ResponseBody List<Activity> findAllActivities() {
		List<Activity> activities = new ArrayList<Activity>();
		
		Activity run =new Activity();
		run.setDesc("Run");
		activities.add(run);
		
		Activity bike =new Activity();
		bike.setDesc("Bike");
		activities.add(bike);
		
		Activity swim =new Activity();
		swim.setDesc("Swim");
		activities.add(swim);
		
		return activities;
	}

}
