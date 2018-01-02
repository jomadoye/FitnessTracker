package com.andela.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.andela.model.Goal;

@Controller
@SessionAttributes("goal")
public class goalController {
	
	@RequestMapping(value = "/addGoal", method= RequestMethod.GET)
	public String addGoal(Model model) {
		Goal goal = new Goal();
		goal.setMinutes(10);
		model.addAttribute("goal", goal);
		
		return "addGoal";
		
	}
	
	@RequestMapping(value = "/addGoal", method= RequestMethod.POST)
	public String updateGoal(@Validated @ModelAttribute("goal") Goal goal, BindingResult result) {
		
		System.out.println("result has errors" + result.hasErrors());
		System.out.println("Minutes updated: " + goal.getMinutes());
		
		return !result.hasErrors() ? "redirect:addMinutes.html" : "addGoal";
		
	}

}
